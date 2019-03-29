package com.holidu.interview.assignment.exceptions;

import org.springframework.http.HttpStatus;

/**
 * This class is extended by other HTTP resource specific exceptions
 *
 * @author lahirua
 */
public class BaseException extends RuntimeException {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -4128719035026198680L;

    /**
     * HttpStatus of the Error.
     */
    private final HttpStatus httpStatus;

    /**
     * Constructor Method.
     * 
     * @param httpStatus
     *            : The Http status assigned to the exception.
     * 
     * @param message
     *            : Exception message to be set.
     */
    public BaseException(HttpStatus httpStatus, String message) {
	super(message);
	this.httpStatus = httpStatus;
    }

    /**
     * Constructor Method.
     * 
     * @param httpStatus
     *            : The Http status assigned to the exception.
     * 
     * @param message
     *            : Exception message to be set.
     * 
     * @param e
     *            : THe exception initial thrown (cause).
     */
    public BaseException(HttpStatus httpStatus, String message, Exception e) {
	super(message, e);
	this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
	return httpStatus;
    }

}
