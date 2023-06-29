import React, {useEffect, useState} from 'react';
import './App.css';
import SearchForm from "./SearchForm";
import {Grid, Header} from "semantic-ui-react";
import NetworksList from "./NetworksList";

function App() {
  const baseURL = "https://bike-rental-aggregator-api.herokuapp.com";

  const [query, setQuery] = useState(null);
  const [networks, setNetworks] = useState([]);
  useEffect(() => {
    if (query != null) {
      console.log("Fetching data for " + query);
      fetch(baseURL + "/networks?name=" + query)
      .then(response => response.json())
      .then(data => {
        console.log("Items found: " + data)
        setNetworks(data)
      });
    }
  }, [query])

  const onSubmit = (query: any) => setQuery(query);

  return (
      <Grid textAlign='center' style={{height: '100vh'}} verticalAlign='middle'>
        <Grid.Column style={{maxWidth: 450}}>
          <Header as='h2' color='teal' textAlign='center'>
            Search bikes close to you :)
          </Header>
          <SearchForm onSubmit={onSubmit}/>
          <NetworksList query={query} networks={networks}/>
        </Grid.Column>
      </Grid>
  );
}

export default App;
