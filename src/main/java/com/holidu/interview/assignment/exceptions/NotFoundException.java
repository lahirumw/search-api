package com.holidu.interview.assignment.exceptions;

import org.springframework.http.HttpStatus;

import com.holidu.interview.assignment.constants.ExceptionMessages;

/**
 * Customized Exception for Not Found. Exception used when a resource is not
 * found in the system.
 * 
 * @author lahirua
 *
 */
public class NotFoundException extends BaseException {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -3926855032933143474L;

    /**
     * Constructor Method.(Default Message).
     *
     */
    public NotFoundException() {
	super(HttpStatus.NOT_FOUND, ExceptionMessages.NOT_FOUND_DEFAULT);
    }

    /**
     * Constructor Method. (Customized Exception)
     * 
     * @param message
     */
    public NotFoundException(String message) {
	super(HttpStatus.NOT_FOUND, message);
    }

    /**
     * Constructor Method. (Exception and Customized Message).
     * 
     * @param message
     *            : Customization message.
     * 
     * @param e
     *            : Exception.
     */
    public NotFoundException(String message, Exception e) {
	super(HttpStatus.NOT_FOUND, message, e);
    }

}
