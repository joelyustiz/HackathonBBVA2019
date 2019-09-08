//@Author William E. Velázquez A. - info@williamvelazquez.com
import React from 'react';

import './final-grade.css';

function FinalGrade(props) {
	const {grade,animated=false}=props;
  return (
    <section className="finalGradeContainer">
			{
				grade &&
				<div className={`grade${grade<=5?' red':`${grade>=6?' green':' yellow'}`}${animated?' animated pulse':''}`}>
					{grade}
				</div>
			}
    </section>
  )
}

export default FinalGrade;