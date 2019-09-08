//@Author William E. Velázquez A. - info@williamvelazquez.com
import React, { Component } from 'react';

import '../libs/animate.css';
import '../libs/bootstrap.min.css';

import './app.css';

import Api from "../utils/api";

import CubeLoader from "../components/CubeLoader";
import ContentLayout from '../components/ContentLayout';
import LabelInput from '../components/LabelInput';
import Button from '../components/Button';
import FinalGrade from './components/FinalGrade';
import CustomTable from  '../components/CustomTable';


class App extends Component {

  constructor(props){
    super(props);
    this.state =  {
      loading: false,
      clientId: 0,
      clientData: {},
      score: 0,
      historyData:[],
      isVisibleHistory: false,
      List:{}
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
    //'B528688042588'
    const serviceURL=`/principal/cliente/${id}`;
    this.handleLoading(true,
      ()=>Api.apiPublicGet(serviceURL, (json)=>
        {
          if (json.codigo != "0") {
            console.log('error');
          }else{
            this.setState({clientData: json.resultado})
          }
          this.handleLoading(false);
        }
        ,()=>this.handleLoading(false)
      )
    );
  }

  handleGetScore = (id) => {
    // console.log('id--->', id);
    const serviceURL=`/principal/cotizador/${id}`;
    this.handleLoading(true,
      ()=>Api.apiPublicGet(serviceURL, (json)=>
        {
          if (json.codigo != "0") {
            console.log('error');
          }else{
            this.setState({score: json.resultado})
          }
          this.handleLoading(false);
        }
        ,()=>this.handleLoading(false)
      )
    );
    this.setState({isVisibleHistory: false})
  }
  
  getResultClient = id => {
    const serviceURL = `/principal/resultados/${id}`
    Api.apiPublicGet(serviceURL, (json)=>
      {
        this.setState({
          score: 0
        })
        if (json.codigo != "0") {
          console.log('error history');
        }else{
          console.log('prueba', json.resultado);
          this.setState({historyData: json.resultado, isVisibleHistory: true})
        }
      }
    )
    this.setState({score: 0})
  }

  render() {
    const {clientId, score, isVisibleHistory}=this.state;
    return (
      <ContentLayout>
        <form className="search-container" onSubmit={(event)=>{event.preventDefault();this.handleGetScore(clientId)}}>
          <LabelInput 
            id="clientId"
            label="Ingresa la clave del cliente:"
            value={clientId}
            placeholder="Clave de Cliente"
            handleChange={this.handleChange}
          />
          <Button 
            text="Calcular"
            handleButtonClick={()=>this.handleGetScore(clientId)}
          />
          <Button 
            text="Ver histórico"
            handleButtonClick={()=>this.getResultClient(clientId)}
          />
        </form>

        {
          score ?
          <FinalGrade grade={score.toFixed(2)} animated={true} />
          : isVisibleHistory ?
          <CustomTable 
            title="-----"
            isVisible
            withIndex
            data={this.state.List}
            headers={this.state.ListHeaders}
            columns={this.state.ListDataColumns}
            noDataTable="Sin Datos"
            isVisibleTotalText
            totalText="..."
          /> :
            <div/>
        }

        {this.state.loading && <CubeLoader />}
      </ContentLayout>
    );
  }
}

export default App;
