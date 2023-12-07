package nus.iss.day19demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nus.iss.day19demo.model.Employee;

// read json file -> map the json objects in the file into an array for us to use

@SpringBootApplication
public class Day19demoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day19demoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pathFileName = "/Users/ruthie/Desktop/codes/vttp23/SSF/day19/employees.json";

		File file = new File(pathFileName);
		InputStream is = new FileInputStream(file);

		// StringBuilder is used for concatenating the contents of the json object to a single string
		StringBuilder resultStringBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line);
			}
		}
		String data = resultStringBuilder.toString();
		// System.out.println(data);
		
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser.parse(data);

		JSONArray jsonArray = (JSONArray) object;
		// System.out.println("jsonArray size: " + jsonArray.size());
		// System.out.println("jsonArray list of objects: " + jsonArray);

		List<Employee> employees = new ArrayList<>();

		jsonArray.forEach(emp -> {
			// System.out.println(emp);

			// call the parseEmployeeObject function
			Employee emp1 = parseEmployeeObject((JSONObject) emp);
			employees.add(emp1);
		});

		// System.out.println();
		// for () {

		// }
	}

	// previous data was local variable. need to parse and add to list of employee object so that it can be used elsewhere also 
	private Employee parseEmployeeObject(JSONObject jsonEmployee) {
		Employee employee =  new Employee();

		JSONObject jsonEmployeeObject = (JSONObject) jsonEmployee.get("employee");
		// System.out.println(jsonEmployeeObject);

		System.out.println(jsonEmployeeObject.get("employeeId"));
		System.out.println(jsonEmployeeObject.get("employeeName"));
		employee.setEmployeeId(Integer.parseInt(jsonEmployeeObject.get("employeeId").toString()));
		employee.setEmployeeName(jsonEmployeeObject.get("employeeName").toString());

		return employee;
	}

}
