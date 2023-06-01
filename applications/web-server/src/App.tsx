import React from 'react';
import './App.css';
import SearchForm from "./SearchForm";
import {Grid, Header} from "semantic-ui-react";

function App() {
  return (
    <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
      <Grid.Column style={{ maxWidth: 450 }}>
        <Header as='h2' color='teal' textAlign='center'>
          Search bikes close to you :)
        </Header>
        <SearchForm />
      </Grid.Column>
    </Grid>
  );
}

export default App;
