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
                                cliente.setMunicipio(rs.getString("municipio"));
                                cliente.setFh_nacimiento(rs.getString("fh_nacimiento"));
                                cliente.setFh_nacimiento_date(rs.getDate("fh_nacimiento_date"));
                                cliente.setCd_giro_banxico(rs.getString("cd_giro_banxico"));
                                cliente.setNb_actividad(rs.getString("nb_actividad"));
                                cliente.setNb_sector_n2(rs.getString("nb_sector_n2"));
                                cliente.setNb_seg_nrb_19(rs.getString("nb_seg_nrb_19"));
                                cliente.setRango_ventas(rs.getString("rango_ventas"));
                                cliente.setFh_antiguedad_banco(rs.getString("fh_antiguedad_banco"));
                                cliente.setFh_antiguedad_banco_date(rs.getDate("fh_antiguedad_banco_date"));
                                cliente.setVentas_tpv(rs.getString("ventas_tpv"));
                                cliente.setOferta_credito_2018(rs.getString("oferta_credito_2018"));
                                cliente.setFh_forma_credito_2018(rs.getString("fh_forma_credito_2018"));
                                cliente.setTdcn(rs.getInt("tdcn"));
                                cliente.setDisponible_tarjeta(rs.getInt("disponible_tarjeta"));
                                cliente.setBcom(rs.getInt("bcom"));
                                cliente.setBneg(rs.getInt("bneg"));
                                cliente.setEmail(rs.getInt("email"));
                                cliente.setCreditos_simples_otorgados_2018(rs.getInt("creditos_simples_otorgados_2018"));
                                cliente.setMora_tarjeta(rs.getInt("mora_tarjeta"));
                                cliente.setMoracs(rs.getInt("moracs"));
                                cliente.setSaldo_cuenta_cheques_jul19(rs.getInt("saldo_cuenta_cheques_jul19"));
                                cliente.setMas_100_mil(rs.getInt("mas_100_mil"));
                                cliente.setMas_300_mil(rs.getInt("mas_300_mil"));
                                cliente.setMas_600_mil(rs.getInt("mas_600_mill"));
                                cliente.setMas_1_millon(rs.getInt("mas_1_millon"));
                                
				return cliente;
			}
		});
        }
}
