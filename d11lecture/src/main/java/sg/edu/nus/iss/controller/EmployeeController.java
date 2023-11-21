package sg.edu.nus.iss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.model.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    // @RequestMapping(path = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ashley", "Chew", "ashchew@visa.com.sg"));
        employees.add(new Employee("Alicia", "Ong", "aliong@visa.com.sg"));
        employees.add(new Employee("Darien", "Lim", "darrlim@visa.com.sg"));

        return employees;
    }
}
