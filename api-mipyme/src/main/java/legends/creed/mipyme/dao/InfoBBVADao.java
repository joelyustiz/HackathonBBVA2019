/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import legends.creed.mipyme.dto.InfoBBVADto;
import legends.creed.mipyme.dto.RespuestaDto;
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
@Repository("info_BBVADao")
public class InfoBBVADao {
    
    	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
        
        @Value("${Info_BBVADao.select.cliente.byClave}")
	private String SQL_SELECT_CLIENTE;
        
        public InfoBBVADto getClienteByClave(RespuestaDto<?> respuesta, String claveCliente){
                MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("cliente", claveCliente);
                
		return  namedParameterJdbcTemplate.queryForObject(SQL_SELECT_CLIENTE, mapSqlParameterSource, new RowMapper<InfoBBVADto>() {
			@Override
			public InfoBBVADto mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoBBVADto cliente = new InfoBBVADto();
				cliente.setCliente(rs.getString("cliente"));
                                cliente.setSexo(rs.getString("sexo"));
                                cliente.setTipo_persona(rs.getString("tipo_persona"));
                                cliente.setCd_estado(rs.getString("cd_estado"));
                                cliente.setCd_postal(rs.getInt("cd_postal"));
				return cliente;
			}
		});
        }
}
