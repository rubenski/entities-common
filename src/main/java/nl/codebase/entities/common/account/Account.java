package nl.codebase.entities.common.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.IOException;

@Getter
@Setter
public class Account {

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String PASSWORD_PATTERN = "[\\d\\w+=_)(*&!$%,.@#/}{\\^-]{8,20}";
    private static final String NAME_PATTERN = "[\\w\\s-']{2,20}";

    protected Long id;

    @NotNull
    @Pattern(regexp = NAME_PATTERN)
    protected String firstName;

    @NotNull
    @Pattern(regexp = NAME_PATTERN)
    protected String lastName;

    @NotNull
    @Email
    protected String email;

    @NotNull
    @Pattern(regexp = "[\\d\\s+]{10,20}")
    protected String phone;

    @Pattern(regexp = PASSWORD_PATTERN)
    protected String password;

    @Pattern(regexp = PASSWORD_PATTERN)
    protected String confirmPassword;

    protected boolean expired = false;
    protected boolean enabled = false;
    protected boolean locked = false;
    protected Grants grants;

    @AssertTrue
    @JsonIgnore
    public boolean isSamePassword() {
        return confirmPassword.equals(password);
    }

    public String grantsToString() {
        try {
            return OBJECT_MAPPER.writer().writeValueAsString(grants);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not serialize Grants to JSON", e);
        }
    }

    public void grantsFromString(String grantsString) {
        try {
            grants = OBJECT_MAPPER.readValue(grantsString, Grants.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize Grants to JSON", e);
        }
    }

}
