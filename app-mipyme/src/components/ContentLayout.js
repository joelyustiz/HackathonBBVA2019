//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

import './content-layout.css';
import Header from './Header';

function ContentLayout(props) {
  return (
    <React.Fragment>
      <Header />
      <div className="layout-content">
        { props.children }
      </div>
    </React.Fragment>
  )
}

export default ContentLayout;