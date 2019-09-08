/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.reglas;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kristian López
 */
public class Actividad {

    public static final Map<String, Double> CALIFICACION = createMap();

    private static Map<String, Double> createMap() {

        Map<String, Double> result = new HashMap<>();

        result.put("?", 2.0);
        result.put("AGROINDUSTRIA", 7.0);
        result.put("ALQUILER DE INMUEBLES", 8.0);
        result.put("AUTOS Y REFACCIONES", 7.0);
        result.put("COMUNICACIONES", 8.0);
        result.put("ELECTRICIDAD", 8.5);
        result.put("ESTACIONES DE GASOLI Y GASERAS", 9.0);
        result.put("GOBIERNO", 10.0);
        result.put("HOTELES", 9.0);
        result.put("INDUSTRIAS BASICAS", 8.0);
        result.put("INSUMOS PARA LA INDUSTRIA", 9.0);
        result.put("MAQUIRIA Y EQUIPO", 8.0);
        result.put("MINERIA", 7.0);
        result.put("NO VIVIENDA", 8.0);
        result.put("OTRAS INDUSTRIAS MANUFACTURERAS", 7.0);
        result.put("OTROS COMERCIANTES", 8.0);
        result.put("OTROS SERVICIOS", 8.0);
        result.put("PAPEL", 5.0);
        result.put("PRODUCTOS A BASE DE MINERALES NO METALICOS", 7.0);
        result.put("QUIMICO", 7.0);
        result.put("RESTAURANT", 8.0);
        result.put("ROPA REGALOS Y CALZADO", 8.0);
        result.put("SERVICIOS DE EDUCACION", 6.0);
        result.put("SERVICIOS DE ESPARCIMIENTO", 7.0);
        result.put("SERVICIOS FINANCIEROS", 7.0);
        result.put("SERVICIOS MEDICOS", 8.0);
        result.put("SERVICIOS PROFESIONALES", 10.0);
        result.put("SUPER Y ABARROTES", 7.0);
        result.put("TEXTIL", 6.0);
        result.put("TRANSPORTE", 8.0);
        result.put("VIVIENDA", 7.0);

        return Collections.unmodifiableMap(result);
    }
}
