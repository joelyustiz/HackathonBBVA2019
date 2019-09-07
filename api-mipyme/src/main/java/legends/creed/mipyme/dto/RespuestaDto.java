/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.dto;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.FieldError;

/**
 *
 * @author Rodrigo Noé Trejo Guerra
 * @param <T>
 */
public class RespuestaDto<T> {
	
	private int codigo;
	private String mensaje;
	private  T resultado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public T getResultado() {
		return resultado;
	}
	public void setResultado(T resultado) {
		this.resultado = resultado;
	}
	public void getMensajesError(List<FieldError> list) {
		this.mensaje = list
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(", "));
	}
	
	
	
	@Override
	public String toString() {
		return "RespuestaDto [codigo=" + codigo + ", mensaje=" + mensaje + ", resultado=" + resultado + "]";
	}

}