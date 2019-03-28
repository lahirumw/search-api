package com.holidu.interview.assignment.utils;

import java.math.BigDecimal;

/**
 * Value Conversion Class
 * 
 * @author lahirua
 *
 */
public final class ConversionUtils {
    
    private ConversionUtils() {
	
    }
    /**
     * Convert input value to BigDecimal
     * 
     * @param input
     * @return
     * @throws Exception 
     */
    public static BigDecimal inputConversion(String input) throws Exception{
	
	return new BigDecimal(input);

    }

}
