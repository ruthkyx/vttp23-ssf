package vttp.ssf.day15demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class Item {

    // cannot be empty
    @NotEmpty(message = "please enter your name")
    private String name;

    // between 1 and 10 
    @Min(value = 1, message = "You must order at least 1 item")
    @Max(value = 10, message = "You can only order up to 10 items!")
    private Integer quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
       return "Item [name=" + name + ", quantity=" + quantity + "]";
    }
    
}
