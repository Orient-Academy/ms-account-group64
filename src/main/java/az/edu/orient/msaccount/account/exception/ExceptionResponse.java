package az.edu.orient.msaccount.account.exception;

import lombok.Builder;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@Builder
public class ExceptionResponse {
    private int code;
    private String message;
    private List<FieldError> fieldErrors;
}
