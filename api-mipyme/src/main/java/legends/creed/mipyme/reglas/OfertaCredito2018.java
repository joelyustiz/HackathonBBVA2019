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
 * @author Rodrigo Noé Trejo Guerra
 */
public class OfertaCredito2018 {
    
    public static final Map<String, Double> CALIFICACION = createMap();
    
    private static Map<String, Double> createMap() {
        Map<String, Double> result = new HashMap<>();
        result.put("#N/D", 7.0);
        result.put("0", 5.0);
        return Collections.unmodifiableMap(result);
    }	
    
}
