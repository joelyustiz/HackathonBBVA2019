/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.service;

import java.util.List;
import legends.creed.mipyme.dao.ResultadosPonderacionesDao;
import legends.creed.mipyme.dto.RespuestaDto;
import legends.creed.mipyme.dto.ResultadosPonderacionesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chacon
 */
@Service("resultadosPonderacionesService")
public class ResultadosPonderacionesService {
    
    @Autowired
    private ResultadosPonderacionesDao resultadosPonderacionesDao;
    
    public List<ResultadosPonderacionesDto> getResultadosPonderaciones(RespuestaDto<List<ResultadosPonderacionesDto>> respuesta, String cliente)throws Exception{
        return resultadosPonderacionesDao.getResultadosPonderaciones(respuesta, cliente);
    }
}