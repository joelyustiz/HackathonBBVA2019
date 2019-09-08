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
public class CatalogoPonderacion {

    public static final Map<String, Double> CALIFICACION = createMap();

    private static Map<String, Double> createMap() {

        Map<String, Double> result = new HashMap<>();

        result.put("tipo_persona", 9.0);
        result.put("actividad", 8.0);
        result.put("rango_ventas", 5.0);
        result.put("tarjeta_credito_negocios", 6.0);
        result.put("disponible_tarjeta", 4.0);
        result.put("creditos_simples_otorgados", 1.0);
        result.put("lo_de_las_moras", 2.0);
        result.put("saldo_cuenta_cheques", 3.0);
        result.put("oferta_de_credito", 7.0);
        result.put("calificacion_de_dominio", 4.0);
        result.put("posicion_en_google", 2.0);
        result.put("razon_social", 6.0);
        result.put("seo", 3.0);
        result.put("zona_geográfica", 5.0);
        result.put("compromiso ambiental", 7.0);
        result.put("pib_entidad", 1.0);

        return Collections.unmodifiableMap(result);
    }

}
