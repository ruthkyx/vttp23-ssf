package nus.iss.day19demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// serializable will help to seriallize the fields in this class
public class Employee implements Serializable {

    Integer employeeId;

    String employeeName;

}
