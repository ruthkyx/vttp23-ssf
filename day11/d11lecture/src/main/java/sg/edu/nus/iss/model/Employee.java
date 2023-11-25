package sg.edu.nus.iss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private String firstName;
    private String lastName;
    private String email;

    // public Employee (String firstName) {
    //     this.firstName = firstName;
    // }

    // public Employee (String firstName, String lastName, String email) {
    //     this.firstName = firstName;
        
    // }

}
