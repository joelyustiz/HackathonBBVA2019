/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.controller;

import legends.creed.mipyme.dto.InfoBBVADto;
import legends.creed.mipyme.reglas.Actividad;
import legends.creed.mipyme.reglas.CatalogoPonderacion;
import legends.creed.mipyme.reglas.OfertaCredito2018;
import legends.creed.mipyme.reglas.RangoVentas;
import legends.creed.mipyme.reglas.TipoPersona;

/**
 *
 * @author krist
 */
public class Ponderacion {

    InfoBBVADto clienteBBVA;
    int ponderacionTotal;

    public Ponderacion(InfoBBVADto clienteBBVA) {

        this.clienteBBVA = clienteBBVA;
    }

    double calcularPonderacion() {

        double tipo_persona = TipoPersona.CALIFICACION.get(clienteBBVA.getTipo_persona());
        double actividad = Actividad.CALIFICACION.get(clienteBBVA.getNb_actividad());
        //System.out.println("Ventas "+clienteBBVA.getRango_ventas()+ ":"+RangoVentas.CALIFICACION);
        double rango_ventas = clienteBBVA.getRango_ventas() == null ? 0.0 :RangoVentas.CALIFICACION.get(clienteBBVA.getRango_ventas().substring(0, 1));
        
        double tdcn = (clienteBBVA.getTdcn() == 1) ? 10.0 : 0.0;
        double disponible_tarjeta = (clienteBBVA.getDisponible_tarjeta() > 0) ? 10.0 : 0.0;
        double oferta = 10.0;
        if(OfertaCredito2018.CALIFICACION.containsKey(clienteBBVA.getOferta_credito_2018())){
            oferta = OfertaCredito2018.CALIFICACION.get(clienteBBVA.getOferta_credito_2018());
        }
        clienteBBVA.getMora_tarjeta();
        clienteBBVA.getMoracs();
        clienteBBVA.getSaldo_cuenta_cheques_jul19();
        clienteBBVA.getCreditos_simples_otorgados_2018();

        //Calificar el dominio
        //Posición en google
        //Razón social
        //SEO
        //Zona geografica
        //Compromiso ambiental
        //PIB por entidad Federal
        
        System.out.println(tipo_persona+":"+CatalogoPonderacion.CALIFICACION.get("tipo_persona"));
        System.out.println(actividad+":"+CatalogoPonderacion.CALIFICACION.get("actividad"));
        System.out.println(rango_ventas+":"+CatalogoPonderacion.CALIFICACION.get("rango_ventas"));
        System.out.println(tdcn+":"+CatalogoPonderacion.CALIFICACION.get("tarjeta_credito_negocios"));
        System.out.println(disponible_tarjeta+":"+CatalogoPonderacion.CALIFICACION.get("disponible_tarjeta"));
        System.out.println(oferta+":"+CatalogoPonderacion.CALIFICACION.get("oferta_de_credito"));
        
        tipo_persona = tipo_persona / (CatalogoPonderacion.CALIFICACION.get("tipo_persona")/10);
        actividad = actividad / (CatalogoPonderacion.CALIFICACION.get("actividad")/10);
        rango_ventas = rango_ventas / (CatalogoPonderacion.CALIFICACION.get("rango_ventas")/10);
        tdcn = tdcn / (CatalogoPonderacion.CALIFICACION.get("tarjeta_credito_negocios")/10);
        disponible_tarjeta = disponible_tarjeta / (CatalogoPonderacion.CALIFICACION.get("disponible_tarjeta")/10);
        oferta = oferta / (CatalogoPonderacion.CALIFICACION.get("oferta_de_credito")/10);
        
        double ponderacion = (oferta + tipo_persona + actividad + rango_ventas + tdcn + disponible_tarjeta)/6;

        return ponderacion;
    }

    /*
Tipo de persona-9
Actividad-8
Rango de ventas-5
Tarjeta de crédito negocios-6
Disponible tarjeta-4
Créditos simples otorgados-1
Lo de las moras-2
Saldo cuenta cheques-3
Oferta de crédito-7
Calificación de dominio-4
Posición en Google-2
Razón social-6
SEO-3
Zona geográfica-5
Compromiso ambiental-7
PIB por entidad-1
     */
}
