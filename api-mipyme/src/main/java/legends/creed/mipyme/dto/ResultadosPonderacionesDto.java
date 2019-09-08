/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.dto;

import java.util.Date;

/**
 *
 * @author chacon
 */
public class ResultadosPonderacionesDto {

    private int id_resultados;
    private double ponderacion_total;
    private String cliente;
    private String rfc;
    private Date fecha_creacion;

    public int getId_resultados() {
        return id_resultados;
    }

    public void setId_resultados(int id_resultados) {
        this.id_resultados = id_resultados;
    }

    public double getPonderacion_total() {
        return ponderacion_total;
    }

    public void setPonderacion_total(double ponderacion_total) {
        this.ponderacion_total = ponderacion_total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
