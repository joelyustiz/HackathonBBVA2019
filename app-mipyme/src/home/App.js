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
import AlertText from '../components/AlertText';
// import CustomTable from  '../components/CustomeTable';

class App extends Component {

  constructor(props){
    super(props);
    this.state =  {
      loading: false,
      clientId: 0,
      clientData: {},
      score: 0,
      errorMsg: ''
    };
  }

  handleLoading = (value, callback) => {
    this.setState({ loading: value }, ()=>{callback && callback()});
  };

  handleError = (error) => {
    this.setState({errorMsg:error}, ()=>setTimeout(()=>this.setState({errorMsg:''}),5000))
  }

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
            // console.log('error');
            this.handleError(json.mensaje);
          }else{
            this.setState({clientData: json.resultado})
          }
          this.handleLoading(false);
        }
        ,()=>{this.handleError('Error al comunicarse con el servidor'); this.handleLoading(false)}
      )
    );
  }

  handleGetScore = (id) => {
    // console.log('id--->', id);
    if(id){
      const serviceURL=`/principal/cotizador/${id}`;
      this.handleLoading(true,
        ()=>Api.apiPublicGet(serviceURL, (json)=>
          {
            if (json.codigo != "0") {
              // console.log('error');
              this.handleError(json.mensaje);
            }else{
              this.setState({score: json.resultado})
            }
            this.handleLoading(false);
          }
          ,()=>{this.handleError('Error al comunicarse con el servidor'); this.handleLoading(false)}
        )
      );
    }else{
      this.handleError('Favor de ingresar una clave de cliente válida.');
    }
  }

  render() {
    const {clientId, score, errorMsg}=this.state;
    return (
      <ContentLayout>
        {
          errorMsg &&
          <AlertText 
            success={false}
            title={errorMsg}
          />
        }
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
        </form>

        {
          score && 
          <FinalGrade grade={score.toFixed(2)} animated={true} />
        }
        {/* {
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
        />
        } */}

        {this.state.loading && <CubeLoader />}
      </ContentLayout>
    );
  }
}

export default App;
