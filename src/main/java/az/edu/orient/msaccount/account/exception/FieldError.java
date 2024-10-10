package az.edu.orient.msaccount.account.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldError {
    private String fieldName;
    private String message;
}
