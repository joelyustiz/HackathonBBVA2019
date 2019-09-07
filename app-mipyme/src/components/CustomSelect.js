import React, { useState, useEffect } from "react";

function CustomSelect(props) {
  const {
    id,
    className,
    name,
    value,
    //defaultValue,
    disabled,
    placeholder,
    placeholderValue,
    data,
    isVisible,
    dataId,
    dataText
  } = props;

  const [valueSelect, setValueSelect] = useState("");

  let content = <div />;

  useEffect(() => {
    setValueSelect(value);
  }, [value]);

  //   useEffect(() => {
  //     setValueSelect(defaultValue);
  //   }, [defaultValue]);

  function handleChange(event) {
    const { onChange } = props;
    const object =
      isNil(data) === false
        ? data.filter(item => {
            return item.id == event.target.value;
          })
        : {};

    onChange(event, event.target.selectedIndex, event.target.value, object[0]);
    setValueSelect(event.target.value);
  }

  if (isVisible === true) {
    content = (
      <select
        id={isNil(id) === false ? id : "exampleCustomSelect"}
        className={isNil(className) ? "form-control" : className}
        name={isNil(name) === false ? name : "customSelect"}
        type="select"
        value={valueSelect}
        disabled={isBoolean(disabled) === true ? disabled : false}
        onChange={handleChange}
      >
        {isNil(placeholder) === false && isEmpty(placeholder) === false ? (
          <option
            style={{ display: "none" }}
            disabled
            key=""
            value={isNil(placeholderValue) ? "" : placeholderValue}
            selected
          >
            {isString(placeholder) ? placeholder : ""}
          </option>
        ) : (
          <option style={{ display: "none" }} disabled key="" value="" />
        )}

        {isNil(data) === false &&
          data.map(item => {
            return (
              <option key={item[dataId]} value={item[dataId]}>
                {isNil(item[dataText]) ? "" : item[dataText]}
              </option>
            );
          })}
      </select>
    );
  }
  return content;
}

export default CustomSelect;