//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

function LabelInput(props) {
    const {id, label, validate, value, type, placeholder, autocomplete, handleChange, helpText} = props;
    return (
        <div className="form-group">
            {
                label &&
                <label 
                    htmlFor={id || null} 
                    className="control-label"
                >
                    {label}
                </label>
            }
            <input 
                id={id || null}
                name={id || null}
                className={validate?"form-control form-control-error":"form-control"}
                value={value || ""}
                type={type || "text"}
                placeholder={placeholder || ""} 
                autoComplete={autocomplete || "off"}
                onChange={handleChange && handleChange.bind(this)}
                required
            />
            {
                validate && helpText &&
                <small className="form-text form-text-error">{helpText}</small>
            }
        </div>
    )
}
export default LabelInput;