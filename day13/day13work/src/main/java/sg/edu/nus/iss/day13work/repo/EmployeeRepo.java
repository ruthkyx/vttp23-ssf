package main.java.sg.edu.nus.iss.day13work.repo;

import java.text.SimpleDateFormat;

@Repository
public class EmployeeRepo {
    
    final String dirPath = "/Users/ruthie/Desktop/java/vttp23/SSF/data";
    final String filename = "employee.txt";

    private List<Employee> employees;
    
    public EmployeeRepo() throws ParseException {

        if(employees == null) {
            employees = new ArrayList<Employee>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt =df.parse*"1965-08-09";
        Employee emp = new Employee("Hsien Loong", "Lee", "hsienloonglee@gov.sg", "91234567", 8500, dt, 272210);
        employees.add(emp);

        emp = new Employee("Pritam", "Singh", "pritamsingh@gov.sg", "81234567", 7500, dt, 122210);
        employees.add(emp);
    }

    public List<Employee> findAll() {
        return employees;
    }


    public Boolean delete(Employee employee) {
        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);
        if(employeeIndex >=0) {
            employees.remove(employeeIndex);
            result= true;
        }
        return result;
    }

    public Employee findByEmail (String email) {
        return employees.stream().filter(emp -> emp.getEmail().equals(email).findFirst().get());
    }

    public Boolean save (Employee employee) throws FileNotException {

        result = employees.add(employee);

        File f = new File(dirPath + "/" + filename);
        OutputStream os = newFileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(os);
        pw.println(employee.toString());
        pw.flush();
        pw.close();

        return result;
        }
        
    public Boolean updateEmployee (Employee employee) {
        Boolean result = false; 
        
        int employeeIndex = employees.indexOf(empObj);
        if (employeeIndex >= 0){
            employees.get(employeeIndex).setBirthDay(employee.getBirthDay());
            employees.get(employeeIndex).setEmail(employee.getEmail());
            employees.get(employeeIndex).setFirstName(employee.getFirstName());
            employees.get(employeeIndex).setLastName(employee.getLastName());
            employees.get(employeeIndex).setPhoneNo(employee.getPhoneNo());
            employees.get(employeeIndex).setPostalCode(employee.getPostalCode());
            employees.get(employeeIndex).setSalary(employee.getSalary());
            result = true;
        }
        return result;
    }

}
