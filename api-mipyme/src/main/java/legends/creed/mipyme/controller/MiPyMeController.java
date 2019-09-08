/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import legends.creed.mipyme.dto.InfoBBVADto;
import legends.creed.mipyme.dto.RespuestaDto;
import legends.creed.mipyme.dto.ResultadosPonderacionesDto;
import legends.creed.mipyme.service.InfoBBVAService;
import legends.creed.mipyme.service.ResultadosPonderacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rodrigo Noé Trejo Guerra
 */
@Controller("miPyMeController")
@RequestMapping(value = "principal")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MiPyMeController {
    @Autowired
    private InfoBBVAService infoBBVAService;
    
    @Autowired
    private ResultadosPonderacionesService resultadosPonderacionesService;
    
    @GetMapping(path = "/cotizador/{cliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody RespuestaDto<String> getCotizacion(@PathVariable(value="cliente") String cliente) {
		RespuestaDto<String> respuesta = new RespuestaDto<>();
		
                String clienteStr = "Cliente: "+cliente;
                respuesta.setCodigo(0);
                respuesta.setMensaje("OK");
                respuesta.setResultado(clienteStr);
                
		return respuesta;
	}
    
    @GetMapping(path = "/cliente/{cliente}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    RespuestaDto<InfoBBVADto> getClienteByClave(@PathVariable(value = "cliente") String cliente) {
        RespuestaDto<InfoBBVADto> respuesta = new RespuestaDto<>();
        if (cliente == null || cliente.equals("")) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("No se encontraron resultados");
        }
        try {
            respuesta.setCodigo(0);
            respuesta.setMensaje("OK");
            respuesta.setResultado(infoBBVAService.getClienteByClave(respuesta, cliente));
        } catch (SQLException e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("No se encontró información");
        }catch (EmptyResultDataAccessException ee){
            respuesta.setCodigo(1);
            respuesta.setMensaje("No se encontró información");
        }
        
        return respuesta;
    }
    
        @GetMapping(path = "/resultados/{cliente}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    RespuestaDto<List<ResultadosPonderacionesDto>> getResultadosPonderaciones(@PathVariable(value = "cliente") String cliente) {
        RespuestaDto<List<ResultadosPonderacionesDto>> respuesta = new RespuestaDto<>();
        if (cliente == null || cliente.equals("")) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("No se encontraron resultados");
        }
        try {
            List<ResultadosPonderacionesDto> resultados = new ArrayList<ResultadosPonderacionesDto>();
            resultados = resultadosPonderacionesService.getResultadosPonderaciones(respuesta, cliente);
            if(resultados.isEmpty()){
                respuesta.setCodigo(1);
                respuesta.setMensaje("No se encontró la información");
            }else{
            respuesta.setCodigo(0);
            respuesta.setMensaje("OK");
            respuesta.setResultado(resultados);
            }
        } catch (Exception e) {
            System.out.println("excepcion......"+e.getMessage());
            e.printStackTrace();
            respuesta.setCodigo(1);
            respuesta.setMensaje("No se encontró información");
        }
        return respuesta;
    }
}
