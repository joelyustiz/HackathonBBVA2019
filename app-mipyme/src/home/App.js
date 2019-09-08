//@Author William E. Velázquez A. - info@williamvelazquez.com
import React, { Component } from 'react';

import CubeLoader from "../components/CubeLoader";

import '../libs/animate.css';
// import * as Constants from 'Constants/app';
import Form from '../form/form'

class App extends Component {

  constructor(props){
    super(props);
    this.state =  {
      loading: true
    };
  }

  handleLoading = (value, callback) => {
    this.setState({ loading: value }, ()=>{callback && callback()});
  };

  render() {
    return (
      <React.Fragment>
        {//this.state.loading && <CubeLoader />
        }
        <Form isVisible>

        </Form>
      </React.Fragment>
    );
  }
}

export default App;
