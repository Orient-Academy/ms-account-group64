package az.edu.orient.msaccount.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(AccountInvalidValueException ex){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(exceptionResponse.getCode()).body(exceptionResponse);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException ex){
       var fieldErrors= ex.getFieldErrors().stream()
                .map(f->FieldError.builder()
                        .fieldName(f.getField())
                        .message(f.getDefaultMessage())
                        .build()).toList();
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getFieldError().getDefaultMessage())
                .fieldErrors(fieldErrors)
                .build();
        return ResponseEntity.status(exceptionResponse.getCode()).body(exceptionResponse);
    }
}
