package com.holidu.interview.assignment.support.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.holidu.interview.assignment.exceptions.BaseException;

/**
 * The base exception wrapper for error responses.
 * 
 * @author lahirua
 *
 */
public class BaseExceptionResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionResponse.class);

    @JsonProperty("code")
    private int code;

    @JsonProperty("description")
    private String description;

    /**
     * Constructor Method.
     * 
     * @param e
     *            : Base exception.
     */
    public BaseExceptionResponse(BaseException e) {
	this.code = e.getHttpStatus().value();
	this.description = e.getMessage();
    }

    /**
     * Constructor Method.
     * 
     * @param code
     *            : The code of the error.
     * 
     * @param description
     *            : The description of the error.
     */
    public BaseExceptionResponse(int code, String description) {
	this.code = code;
	this.description = description;
    }

    public int getCode() {
	return code;
    }

    public String getDescription() {
	return description;
    }

    /**
     * Generate JSON string to set to Response.
     */
    @Override
    public String toString() {

	try {

	    ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(this);

	} catch (JsonProcessingException e) {
	    LOGGER.error("Exception Occured: ", e);
	    return "{\"error\":\"internal_server_error\"}";
	}
    }

}
