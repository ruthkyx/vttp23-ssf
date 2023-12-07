package nus.iss.day18.day18lect.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    
    // required, only digits
    @NotBlank(message="field is required!")
    @Digits(message="numbers only!", fraction = 0, integer = 10000)
    private Integer annId;

    // contain only letters [a-zA-Z]
    private String code;

    // required, min 10 char, max 50 char
    @NotBlank (message="field is required!")
    @Min(value=10, message="must be at least 10 characters")
    @Max(value=50, message="must be less than 50 characters")
    private String title;

    // required
    @NotBlank(message="field is required!")
    private String message;

    // date greater than today
    @Past(message="date must be before today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
}
