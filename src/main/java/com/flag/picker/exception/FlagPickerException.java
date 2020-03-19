package com.flag.picker.exception;

/**
 * The Class FlagPickerException.
 */
public class FlagPickerException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /** The err msg. */
    private String errorMessage;

    /**
     * Gets the err msg.
     * 
     * @return the err msg
     */
    public final String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the err msg.
     * 
     * @param errMsg the new err msg
     */
    public final void setErrorMessge(final String errMsg) {
        this.errorMessage = errMsg;
    }

    /**
     * Instantiates a new generic controller exception.
     *
     * @param errMsg the err msg
     * @param e the exception
     */
    public FlagPickerException(final String errMsg, final Exception e) {
        super(errMsg, e);
        this.errorMessage = errMsg;
    }

    /**
     * Instantiates a new generic controller exception.
     *
     * @param errMsg the err msg
     */
    public FlagPickerException(final String errMsg) {
    	super(errMsg);
        this.errorMessage = errMsg;
    }
}