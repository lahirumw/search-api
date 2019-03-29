package com.holidu.interview.assignment.constants;

/**
 * Messages to be set for exceptions.
 * 
 * @author lahirua
 *
 */
public final class ExceptionMessages {

    public static final String BASE_DEFAULT = "An internal server error has occured.";

    public static final String BAD_REQUEST_DEFAULT = "The request is invalid. Please try again";

    public static final String NOT_FOUND_DEFAULT = "Resource Not Found";

    public static final String VALIDATION_DEFAULT = "Data input is invalid.";

    public static final String INTERNAL_DEFAULT = "An internal error has occurred, Please try again later";


    private ExceptionMessages() {
	// private constructor to prevent creation.
    }

}
