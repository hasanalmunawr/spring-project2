package hasanalmunawr.Dev.springproject2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @NotEmpty(message = "First Name Can Not Empty")
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Email Can Not Empty")
    @Email(message = "Invalid email addres")
    private String email;
    @NotEmpty(message = "Password Can Not Empty")
    private String password;
    private String bio;
    private String phone;

}
