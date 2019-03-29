package com.holidu.interview.assignment.support.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.holidu.interview.assignment.constants.ExceptionMessages;
import com.holidu.interview.assignment.exceptions.BaseException;
import com.holidu.interview.assignment.support.dto.BaseExceptionResponse;


/**
 * Class extended by all API controllers for Error and Exception Handling.
 *
 * @author lahirua
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

    private static final String EXCEPTION_TRACE = "Exception Trace:";

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    /**
     * constructor
     */
    public ControllerExceptionAdvice() {
	super();
    }

    /**
     * Method to handle Resource Exceptions thrown by Controllers
     * 
     * @param e
     *            : The base exception object.
     * 
     * @param request
     *            : The Http request object.
     * 
     * @param response
     *            : The Http response object.
     * 
     * @return {@link ResponseEntity}
     * 
     * @throws IOException
     *             : Input/output exception.
     */
    @ExceptionHandler({ BaseException.class })
    public ResponseEntity<String> handleResourceException(BaseException e, HttpServletRequest request,
	    HttpServletResponse response) {

	LOGGER.error(EXCEPTION_TRACE, e);

	HttpHeaders responseHeaders = new HttpHeaders();

	responseHeaders.setContentType(MediaType.APPLICATION_JSON);

	BaseExceptionResponse exceptionDto = new BaseExceptionResponse(e);

	return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, e.getHttpStatus());
    }

    /**
     * Method to handle Exceptions thrown by Controllers
     * 
     * @param e
     *            : The exception thrown from the controller.
     * 
     * @param request
     *            : The request object.
     * 
     * @param response
     *            : The response object.
     * 
     * @return {@link ResponseEntity}
     * 
     * @throws IOException
     *             : Input/output exception.
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleException(Exception e, HttpServletRequest request,
	    HttpServletResponse response) {

	LOGGER.error(EXCEPTION_TRACE, e);

	HttpHeaders responseHeaders = new HttpHeaders();

	responseHeaders.setContentType(MediaType.APPLICATION_JSON);

	HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	BaseExceptionResponse exceptionDto = new BaseExceptionResponse(httpStatus.value(),
		ExceptionMessages.INTERNAL_DEFAULT);

	return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, httpStatus);
    }


}
