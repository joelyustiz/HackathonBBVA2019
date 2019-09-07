import React from "react";

function CustomInput(props) {
  const {
    id,
    disabled,
    value,
    type,
    autoComplete,
    placeholder,
    className,
    min,
    max,
    //toBlock,
    onChange,
    onClick,
    onFocus,
    onBlur,
    onKeyPress,
    isVisible,
    required
  } = props;
  let content = <div />;

  if (isVisible === true) {
    content = (
      <input
        id={isNil(id) ? "input" : id}
        value={isNil(value) === false ? value : ""}
        disabled={isNil(disabled) ? false : disabled}
        required={isNil(required) ? false : required}
        type={isNil(type) === false && isEmpty(type) === false ? type : "text"}
        placeholder={
          isNil(placeholder) === false && isEmpty(placeholder) === false
            ? placeholder
            : ""
        }
        autoComplete={
          isNil(autoComplete) === false && isEmpty(autoComplete) === false
            ? "on"
            : "off"
        }
        className={
          isNil(className) && isEmpty(className) ? "form-control" : className
        }
        min={isEmpty(min) === false && isNil(min) === false ? min : ""}
        max={isEmpty(max) === false && isNil(max) === false ? max : ""}
        onChange={event => {
          if (typeof onChange === "function") {
            return onChange(event, event.target.value);
          }
        }}
        onClick={event => {
          if (typeof onClick === "function") {
            return onClick(event, event.target.value);
          }
        }}
        onFocus={event => {
          if (typeof onFocus === "function") {
            return onFocus(event, event.target.value);
          }
        }}
        onBlur={event => {
          if (typeof onBlur === "function") {
            return onBlur(event, event.target.value);
          }
        }}
        onKeyPress={event => {
          //event.which == 13 || event.keyCode == 13
          if (typeof onKeyPress === "function") {
            return onKeyPress(event, event.target.value);
          }
        }}
      />
    );
  }
  return content;
}

export default CustomInput;