//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from "react";
import { render } from "react-dom";
import "babel-polyfill";

import App from "../home/App";

const container = document.getElementById("app");

render(<App />, container);
