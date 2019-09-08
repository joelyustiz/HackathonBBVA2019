/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import legends.creed.mipyme.dto.RespuestaDto;
import legends.creed.mipyme.dto.ResultadosPonderacionesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chacon
 */
@Repository("resultadosPonderacionesDao")
public class ResultadosPonderacionesDao {
        @Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
        
        @Value("${ResultadosPonderacionesDao.select.resultados.byClave}")
	private String SQL_SELECT_RESULTADOS;

	public List<ResultadosPonderacionesDto> getResultadosPonderaciones(RespuestaDto<?> respuesta, String cliente) throws Exception{

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("cliente", cliente);

		return  namedParameterJdbcTemplate.query(SQL_SELECT_RESULTADOS, mapSqlParameterSource, new RowMapper<ResultadosPonderacionesDto>() {
			@Override
			public ResultadosPonderacionesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ResultadosPonderacionesDto resultados = new ResultadosPonderacionesDto();
                                resultados.setId_resultados(rs.getInt("id_resultados"));
                                resultados.setPonderacion_total(rs.getDouble("ponderacion_final"));
                                resultados.setCliente(rs.getString("cliente"));
                                resultados.setRfc(rs.getString("rfc"));
                                resultados.setFecha_creacion(rs.getDate("fecha_creacion"));
				return resultados;
			}
		});
	}
}
