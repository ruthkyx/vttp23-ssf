package ssf.pizza.practice.ssfpracticepizza.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @NotBlank(message="Field is required!")
    @Size(min=3)
    private String name;

    @NotBlank(message="Field is required!")
    private String address;

    @NotBlank
    @Pattern(regexp="(8|9)[0-9]{7}")
    private String phone;

    private boolean rush;

    private String comments;
}
