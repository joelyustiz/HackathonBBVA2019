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
public class TipoPersona {

    public static final Map<String, Double> CALIFICACION = createMap();

    private static Map<String, Double> createMap() {

        Map<String, Double> result = new HashMap<>();

        result.put("?", 5.0);
        result.put("Físicas", 5.0);
        result.put("Gobierno", 10.0);
        result.put("Morales", 10.0);
        result.put("PFAEs", 10.0);

        return Collections.unmodifiableMap(result);
    }

}
