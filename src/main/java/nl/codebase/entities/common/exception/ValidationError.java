package nl.codebase.entities.common.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError {

    private String message;
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ValidationError(String message) {
        this.message = message;
    }

    public ValidationError() {
    }

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message);
        fieldErrors.add(error);
    }
}
