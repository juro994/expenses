package sk.juraj.projects.expenses.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<ApiError> handleConflict(HttpServletRequest request, Throwable exception) {
		var apiError = new ApiError(HttpStatus.CONFLICT, exception.getMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		var apiError = new ApiError(HttpStatus.BAD_REQUEST, errorMessage);
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
}