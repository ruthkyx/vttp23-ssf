package main.java.sg.edu.nus.iss.day13work.controller;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/list")
    public String employeeList(Model model) {
        List <Employee> employees = empRepo.findAll();

        model.addAttribute("employees", employees);

        return "employeelist";
    }

    @GetMapping("/addnew")
    public String employeeAdd(Model model) {
        Employee emp = new Employee();
        model.addAtrribute("employee", emp);

        return "employeeadd";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult result, Model model) {
        if(result.hasErrrors()) {
            return "employeeadd";
        }

        Boolean returnResult = empRepo.save(employeeForm);

        // return "redirect:/employees/list";
        model.addAttribute("savedEmployee", employeeForm);
        return success;
    }

        @GetMapping("/employeedelete/{email}")
        public String deleteEmployee(@PathVariable("email") String email) {

            Employee emp = empRepo.findByEmail(email);
            Boolean bResult = empRepo.delete(emp);
            return "redirect:/employees/home";
    }

    @GetMapping("/employeeudpate/{email}")
    public String updateEmployee(@PathVariable("email") String email, Model model) {

        Employee emp = empRepo.findByEmail(email);
        model.addAttribute("employee", emp);
    }

    @PostMapping("/updEmployee")
    public String updateEmployeeRecord(@ModelAttribute("employee"), Employee emp, BindingResult result, Model model) {
        if(result.hasErrrors()) {
            return "employeeupdate";
        }

        empRepo.updateEmployee(emp);
        return "redirect:/employees/list";
    }

}
