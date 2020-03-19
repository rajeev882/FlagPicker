package com.flag.picker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static com.flag.picker.config.FlagPickerContants.FLAGPICKER;
import static com.flag.picker.config.FlagPickerContants.FLAG_PICKER_GLOBAL_ERROR;

/**
 * @author Rajeev kumar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

	/**
	 * 
	 * Handles the Global Exception.
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleError(Exception exception) {
		final String errorMessage = FLAG_PICKER_GLOBAL_ERROR;
		return constructResponseEntity(exception, errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Method to construct the response entity
	 * 
	 * @param exception
	 * @param errorMsg
	 * @param httpStatus
	 * @return
	 */
	private ResponseEntity<ErrorMessage> constructResponseEntity(final Exception exception, final String errorMsg,
			final HttpStatus httpStatus) {
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setModuleName(FLAGPICKER);
		errorMessage.setErrorMessage(errorMsg);
		logger.error("Exception = ", exception);
		return new ResponseEntity<ErrorMessage>(errorMessage, httpStatus);
	}
}
