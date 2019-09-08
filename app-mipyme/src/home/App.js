//@Author William E. Velázquez A. - info@williamvelazquez.com
import React, { Component } from 'react';

import '../libs/animate.css';
import '../libs/bootstrap.min.css';

import './app.css';

import Api from "../utils/api";

import AlertText from '../components/AlertText';
import CubeLoader from "../components/CubeLoader";
import ContentLayout from '../components/ContentLayout';
import LabelInput from '../components/LabelInput';
import Button from '../components/Button';
import FinalGrade from './components/FinalGrade';
import CustomTable from  '../components/CustomTable';
 const  tableHeaders=[
  { text: "Cliente" },
  { text: "Fecha de cotización" },
  { text: "Ponderación" }
];
const tableDataColumns=[
  { key: "cliente", type: "1", textPosition: "center" },
  { key: "fecha_creacion", type: "1", textPosition: "center" },
  { key: "ponderacion_total", type: "1", textPosition: "center" },
];

class App extends Component {

  constructor(props){
    super(props);
    this.state =  {
      loading: false,
      clientId: 0,
      clientData: {},
      score: 0,
      errorMsg: '',
      historyData:[],
      isVisibleHistory: false,
      List:{},
      ListHeaders:{},
      ListDataColumns:{}
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

    this.setState({
      isVisibleHistory: false
    })
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

    this.setState({isVisibleHistory: false})
  }
  
  getResultClient = id => {
    const serviceURL = `/principal/resultados/${id}`
    if (id) {
      Api.apiPublicGet(serviceURL, (json)=>
      {
        this.setState({
          score: 0
        })
        if (json.codigo != "0") {
          //console.log('error history');
          this.handleError(json.mensaje);
        }else{
          console.log('prueba', json.resultado);
          this.setState({historyData: json.resultado, isVisibleHistory: true})
        }
      }
    )
    } else {
      this.handleError('Favor de ingresar una clave de cliente válida.');
    }
    this.setState({score: 0})
  } 

  render() {
    const {clientId, score, errorMsg, isVisibleHistory, historyData} = this.state;
    return (
      <ContentLayout>
        <div className="container-parrafo">
          <div className="skewed">
            <h1 className="title">
            Bienvenido a tu ayudante PyMeCre
            </h1>
            <p className="parrafo">Tu herramienta para validar si una empresa es apta para un crédito</p>
          </div>
          <div className="triangle"></div>
        </div>
        
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
          <Button 
            text="Ver histórico"
            className="boton-historico"
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
            data={this.state.historyData}
            headers={tableHeaders}
            columns={tableDataColumns}
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
