//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

import './toggle-switch.css';

function ToggleSwitch(props) {
  const {id, isChecked, handleToggle, trueColor, falseColor } = props;
  return (
    <React.Fragment>
      <input
        type="checkbox"
        id={id||`switch-new`}
        checked={isChecked}
        onChange={handleToggle}
        className="switch-checkbox"
      />
      <label
        style={{ background: isChecked ? trueColor : falseColor }}
        className="switch-label"
        htmlFor={id||`switch-new`}
      >
        <span className={`switch-button`} />
      </label>
    </React.Fragment>
  );
}
export default ToggleSwitch;
