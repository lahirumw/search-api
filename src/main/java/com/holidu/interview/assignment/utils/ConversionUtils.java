package com.holidu.interview.assignment.utils;

import java.math.BigDecimal;

import com.holidu.interview.assignment.constants.ExceptionMessages;
import com.holidu.interview.assignment.exceptions.BadRequestException;

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
    public static BigDecimal inputConversion(String input){
	
	try {
	    return new BigDecimal(input);
	}catch(Exception e) {
	    
	    throw new BadRequestException(ExceptionMessages.VALIDATION_DEFAULT, e);
	}

    }

}
