//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

function Button(props) {
    const {style, centered, className, id, title, type, handleButtonClick, disabled, text} = props;
    return (
        <button 
            className={`btn btn-${style||"primary"}${centered?" center-block":""}${className?" " + className:""}`}
            id={id || null}
            title={title || null}
            type={type || "button"}
            onClick={handleButtonClick || null}
            disabled={disabled || false}
        >
            {text}
        </button>
    )
}
export default Button;