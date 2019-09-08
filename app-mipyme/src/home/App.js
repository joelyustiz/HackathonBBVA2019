//@Author William E. Velázquez A. - info@williamvelazquez.com
import React, { Component } from 'react';

import '../libs/animate.css';
import '../libs/bootstrap.min.css';

import './app.css';

import CubeLoader from "../components/CubeLoader";
import ContentLayout from '../components/ContentLayout';
import LabelInput from '../components/LabelInput';
import Button from '../components/Button';
// import * as Constants from 'Constants/app';

class App extends Component {

  constructor(props){
    super(props);
    this.state =  {
      loading: false,
      clientId: 0
    };
  }

  handleLoading = (value, callback) => {
    this.setState({ loading: value }, ()=>{callback && callback()});
  };

  handleChange = event => {
    // console.log(`value-->${event.target.value} | id-->${event.target.id}`);
    this.setState({
      [event.target.id]: event.target.value
    });
  };

  handleSearchClient = (id) => {
    console.log('id--->', id);
  }

  render() {
    const {clientId}=this.state;
    return (
      <ContentLayout>
        <section className="search-container">
          <LabelInput 
            id="clientId"
            label="Ingresa la clave del cliente:"
            value={clientId}
            placeholder="Clave de Cliente"
            handleChange={this.handleChange}
          />
          <Button 
            text="Buscar"
            handleButtonClick={()=>this.handleSearchClient(clientId)}
          />
        </section>
        {this.state.loading && <CubeLoader />}
      </ContentLayout>
    );
  }
}

export default App;
