package nl.codebase.entities.common.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RestValidationError {

    private Date timestamp;
    private List<FieldValidationError> fieldErrors = new ArrayList<>();

    public RestValidationError() {
        this.timestamp = new Date();
    }

    public void addError(FieldValidationError error) {
        fieldErrors.add(error);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class FieldValidationError {

        private String fieldName;
        private String rejectedValue;
    }
}
