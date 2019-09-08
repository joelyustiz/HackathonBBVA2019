//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

import './alert-text.css';

function AlertText(props) {
  const {success, title, msg, children} = props;
  return (
    <div className={`alertContainer alertBox${success?" alertSuccess":" alertError" }`}>
      <strong>{ title }</strong>
      <p className="text">{ msg }</p>
      { children }
    </div>
  )
}

export default AlertText;