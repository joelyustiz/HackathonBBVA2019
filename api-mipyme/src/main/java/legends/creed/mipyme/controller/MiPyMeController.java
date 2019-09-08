/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.controller;

import legends.creed.mipyme.dto.InfoBBVADto;
import legends.creed.mipyme.dto.RespuestaDto;
import legends.creed.mipyme.service.InfoBBVAService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/cotizador/{cliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody RespuestaDto<String> getCotizacion(@PathVariable(value="cliente") String cliente) {
        RespuestaDto<String> respuesta = new RespuestaDto<>();

                String clienteStr = "Cliente: "+cliente;
        respuesta.setCodigo(0);
        respuesta.setMensaje("OK");
        respuesta.setResultado(clienteStr);

        return respuesta;
    }

        @GetMapping(path = "/cliente/{cliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody RespuestaDto<InfoBBVADto> getClienteByClave(@PathVariable(value="cliente") String cliente) {
        RespuestaDto<InfoBBVADto> respuesta = new RespuestaDto<>();

                String clienteStr = "Cliente: "+cliente;
        respuesta.setCodigo(0);
        respuesta.setMensaje("OK");
        respuesta.setResultado(infoBBVAService.getClienteByClave(respuesta, cliente));

        return respuesta;
    }
}
