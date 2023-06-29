import React from 'react';
import 'semantic-ui-css/semantic.min.css'
import {Icon, Label, Grid, Container, Header} from 'semantic-ui-react';

interface Props {
  query: string | null
  networks: any[]
}

function NetworksList(props: Props) {
  var hasNoItems = props.networks.length === 0;
  var noFilter = props.query === null;

  if (hasNoItems && noFilter) {
    return <Header as='h5' style={{marginTop: 50}}>Hint: try to search using the keyword "Nextbike"</Header>;;
  }
  if (hasNoItems) {
    return <Header as='h5' style={{marginTop: 50}}>No results found</Header>;
  }
  return (
      <Container fluid textAlign='left'>
        <Header as='h3' style={{marginTop: 50}}>Results:</Header>
        <Grid columns={3} padded verticalAlign='middle' divided='vertically'
              style={{overflow: 'auto', maxHeight: 500, marginTop: 20}}>
          {props.networks.map(network => (
              <Grid.Row>
                <Grid.Column>
                  <Label as='a' color='red' ribbon>
                    <Icon name='bicycle'/> {network.name}
                  </Label></Grid.Column>
                <Grid.Column><b>ID:</b> <br/>{network.id}</Grid.Column>
                <Grid.Column><b>Companies:</b> {network.companies}</Grid.Column>
              </Grid.Row>
          ))}
        </Grid>
      </Container>
  );
}

export default NetworksList;