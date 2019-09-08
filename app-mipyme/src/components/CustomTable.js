//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from "react";

import '../custom-table.css';

function CustomTable(props) {
  const {
    title,
    isVisible,
    data,
    columns,
    headers,
    noDataText,
    totalText,
    isVisibleTotalText,
    setClassInTextRow,
    handleMoreInfo,
    withIndex
  } = props;

  let content = <div />;

  function getTextPosition(value) {
    let data = {};
    if (value.textPosition !== null && value.textPosition !== undefined) {
      data.textAlign = value.textPosition;
    }
    return data;
  }

  if (isVisible === true) {
    content = (
      <div className="row">
        <div className="">
          <div className="container-table">
            <h3>{title}</h3>
						<hr class="red" />
            <table
              className={`table table-striped table-responsive${
                data.length > 0 ? "" : " noBottom"
              }`}
            >
              <thead>
                <tr>
                  {
                    !!withIndex &&
                    <th style={getTextPosition({textPosition: "center"})}>#</th>
                  }
                  {Array.isArray(headers) &&
                    headers.map(item => {
                      return <th style={getTextPosition(item)}>{item.text}</th>;
                    })}
                </tr>
              </thead>
              <tbody>
                {data.length > 0 ? (
                  data.map((item,index) => {
                    return (
                      <tr>
                        {
                          !!withIndex &&
                          <td>{index}</td>
                        }
                        {Array.isArray(columns) &&
                          columns.map(columnsValue => {
                            let component = <div />;

                            switch (columnsValue.type) {
                              case "1":
                                component = (
                                  <td
                                    className={
                                      typeof setClassInTextRow === "function"
                                        ? setClassInTextRow(item)
                                        : ""
                                    }
                                    style={getTextPosition(columnsValue)}
                                  >
                                    {item[columnsValue.key]
                                      ? item[columnsValue.key]
                                      : ""}
                                  </td>
                                );
                                break;
                              case "2":
                                component = (
                                  <td>
                                    <span
                                      className={
                                        columnsValue.icon
                                          ? columnsValue.icon
                                          : ""
                                      }
                                      onClick={() => {
                                        if (
                                          typeof handleMoreInfo === "function"
                                        ) {
                                          handleMoreInfo(item);
                                        }
                                      }}
                                    />
                                  </td>
                                );
                                break;
                              default:
                                component = <div />;
                                break;
                            }
                            return component;
                          })}
                      </tr>
                    );
                  })
                ) : (
                  <tr>
                    <td>
                      <br />
                      <h4>{noDataText}</h4>
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>

          {data.length > 0 && isVisibleTotalText && (
            <p className="paging">{`${data.length} ${totalText}`}</p>
          )}
        </div>
      </div>
    );
  }
  return content;
}

export default CustomTable;