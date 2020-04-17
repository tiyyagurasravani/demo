package com.telecom.demo10.Exception;

       import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;
        import com.telecom.demo10.dto.ErrorMessage;
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchCustomerException ex) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
