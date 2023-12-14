package nus.iss.d15shoppingcart.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    
    @NotBlank(message="field is required!")
    public String name;

    @NotBlank
    @Min(value=1, message=("min purchase qty is 1"))
    @Max(value=30, message="max qty that can be purchased is 30!")
    public Integer quantity;

}
