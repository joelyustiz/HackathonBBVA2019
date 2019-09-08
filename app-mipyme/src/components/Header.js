import React from 'react';

import './header.css';

import {BBVA_LOGO} from 'Constants/files';

function Header(props) {
  return (
    <header className="header">
        <img src={BBVA_LOGO} alt="BBVA" />
    </header>
  )
}

export default Header;