/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.service;

import java.sql.SQLException;
import legends.creed.mipyme.dao.InfoBBVADao;
import legends.creed.mipyme.dto.InfoBBVADto;
import legends.creed.mipyme.dto.RespuestaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author chacon
 */
@Service("infoBBVAService")
public class InfoBBVAService {

    @Autowired
    private InfoBBVADao infoBBVADao;
    
    public InfoBBVADto getClienteByClave(RespuestaDto<InfoBBVADto> respuesta, String claveCliente) throws SQLException, EmptyResultDataAccessException {
        return infoBBVADao.getClienteByClave(respuesta, claveCliente);
    }
}
