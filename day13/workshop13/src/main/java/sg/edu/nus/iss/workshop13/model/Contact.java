package sg.edu.nus.iss.workshop13.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    
    @NotEmpty (message = "name is a required field!")
    private String name;

    @NotEmpty(message ="phone number is required!")
    @Pattern(regexp="(8|9)[0-9]{7}", message="sg phone numbers are 8 digits and starts w 8/9")
    private String phone;

    @NotEmpty(message="email is a required field")
    private String email;

    @NotEmpty(message="please input your birth date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

    public Contact(String name, String phone, String email, DateFormat bday) {

    }

}
