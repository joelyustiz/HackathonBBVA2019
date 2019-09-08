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
public class RangoVentas {
    
    public static final Map<String, Double> CALIFICACION = createMap();

    private static Map<String, Double> createMap() {
        Map<String, Double> result = new HashMap<>();
        result.put("A", 0.6);
        result.put("B", 1.2);
        result.put("C", 1.8);
        result.put("D", 2.4);
        result.put("E", 3.0);
        result.put("F", 3.6);
        result.put("G", 4.2);
        result.put("H", 4.8);
        result.put("I", 5.4);
        result.put("J", 6.0);
        result.put("K", 6.6);
        result.put("L", 7.2);
        result.put("M", 7.8);
        result.put("N", 8.4);
        result.put("O", 9.0);
        result.put("P", 9.6);
        result.put("Q", 10.0);
        return Collections.unmodifiableMap(result);
    }	
    
}
