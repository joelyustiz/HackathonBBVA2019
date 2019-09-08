import React from 'react'
import CustomInput from '../components/CustomInput'

function Form(props) {
    const {isVisible} = props;
    let component = <div></div>

    if (isVisible) {
        component = (
            <React.Fragment>
                <form>
                    <CustomInput isVisible></CustomInput>
                </form>
            </React.Fragment>
        )
    }

    return component
} 

export default Form;