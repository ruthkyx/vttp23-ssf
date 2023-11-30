package iss.ssf.day16demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@SpringBootApplication
public class Day16demoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day16demoApplication.class, args);
	}

	@Override
	public void run(String ... args) throws Exception {
		// get a JsonObjectBuidler & build the Json object 
		JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add("firstName", "fred");
			builder.add("lastName", "flintstone");
			builder.add("age", "50");
			builder.add("married", true);
			builder.add("height", 5.9);

		// creating the Json obbject
		JsonObject fred = builder.build();

		// JsonObject wilma = Json.createObjectBuilder()
		// 		.add("firstName", "wilma")
		// 		.add("lastName", "flintstone")
		// 		.add("age", true)
		// 		.add("height", 5.3)
		// 		.add("spouse", fred)
		// 		.build();

		JsonArray flintstones = Json.createArrayBuilder()
				.add(fred)
		// 		.add(wilma)
				.build();
				
		System.out.printf("... fred: \n %s\n", fred.toString());
		System.out.printf("... flintstones: \n %s\n", flintstones.toString());

		// String name = wilma.getString("firstName");
		// boolean married = wilma.getBoolean("married");
		// Integer age = wilma.getInt("age", -1);
		// there's no float in json 
		// float height = (float)(wilma.getJsonNumber ("height").doubleValue());
		// JsonObject spouse = wilma.getJsonObject("spouse");

		// method using normal for loop
		for (int i = 0; i < flintstones.size(); i++) {
		JsonObject o = flintstones.getJsonObject(i);
		System.out.printf("%d >>> %s\n", i, o);
		}

		// alternative method using stream 
		flintstones.stream()
			.map(v -> v.asJsonObject())
			.forEach(jo -> {
			System.out.printf("Stream: %s\n", jo);
			});

	}

}
