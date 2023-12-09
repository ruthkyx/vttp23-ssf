package sg.edu.nus.iss.workshop13.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NotEmpty(message = "name is a required field!")
    private String name;

    @NotEmpty
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "phone number invalid!")
    private String phone;

    @NotEmpty(message = "email is a required field")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "please input your birth date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

    @Override
    public String toString() {
        return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + "]";
    }

}
