/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legends.creed.mipyme.enums;

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
        result.put("A. Menor a 01M", 0.6);
        result.put("B. 01M-02M", 1.2);
        result.put("C. 02M-03M", 1.8);
        result.put("D. 03M-04M", 2.4);
        result.put("E. 04M-05M", 3.0);
        result.put("F. 05M-06M", 3.6);
        result.put("G. 06M-08M", 4.2);
        result.put("H. 08M-10M", 4.8);
        result.put("I. 10M-12M", 5.4);
        result.put("J. 12M-15M", 6.0);
        result.put("K. 15M-16M", 6.6);
        result.put("L. 16M-18M", 7.2);
        result.put("M. 18M-20M", 7.8);
        result.put("N. 20M-30M", 8.4);
        result.put("O. 30M-40M", 9.0);
        result.put("P. 40M-50M", 9.6);
        result.put("Q. +50M", 10.0);
        return Collections.unmodifiableMap(result);
    }	
    
}
