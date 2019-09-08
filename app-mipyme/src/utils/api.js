//@Author William E. Velázquez A. - info@williamvelazquez.com
import isEmpty from 'lodash/isEmpty'

import { PUBLIC_URL } from 'Constants/app';

const GET_TYPE = 'GET';
const POST_TYPE = 'POST';

class Api{

  apiPublicGet = async(URL, callback, errorCallback, headerAccept, headerContentType) => {
    const service = PUBLIC_URL + URL;
    this.apiHttpRequest(GET_TYPE, service, {}, callback, errorCallback, headerAccept, headerContentType);
  }
  
  apiPublicPost = async(URL, body, callback, errorCallback, headerAccept, headerContentType) => {
    const service = PUBLIC_URL + URL;
    this.apiHttpRequest(POST_TYPE, service, body, callback, errorCallback, headerAccept, headerContentType);
  }
  
  apiHttpRequest = async(methodType, service, body, callback, errorCallback, headerAccept, headerContentType) => {
    try {
      //DEBUG-->console.log("Env: ", process.env.NODE_ENV);
      //DEBUG-->console.log("body:",body)
      
      let requestConfig = 
      {
        method: (methodType||'GET'),
        headers: {
          Accept: (headerAccept||'application/json'),
          'Content-Type': (headerContentType||'application/json')
        }
      }; 

      (body && !isEmpty(body)) ? requestConfig.body=JSON.stringify({...body}):null;
      
      //DEBUG-->console.log("Request configuration:", requestConfig);

      //const requestURL = (process.env.NODE_ENV === 'production' || process.env.NODE_ENV === 'none')?PROD_API_URL:DEV_API_URL;
      const response = await fetch(service, requestConfig);

      if (response.status != 200) {
        //DEBUG-->console.log(`Error code: ${response.status} | Message: ${response.mensaje}`);
        throw Error(response.mensaje);
      } else {
        const json = await response.json();
        //DEBUG-->console.log("JSON:",json);
        callback && await callback(json);
      }
    } catch (error) {
      console.log('Catch:', error);
      errorCallback && await errorCallback(error);
    }
  }
}

export default new Api();