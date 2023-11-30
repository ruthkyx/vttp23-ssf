package vttp.ssf.day15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class Day15demoApplication implements CommandLineRunner {

	@Autowired @Qualifier(Utils.BEAN_REDIS) 
	private RedisTemplate<String, String> template; 

	public static void main(String[] args) {
		SpringApplication.run(Day15demoApplication.class, args);
	}

	@Override 
	public void run (String... args) throws Exception {
		System.out.printf(">>> redisTemplate: %s\n", template);

		// select 0 
		// set name fred
		ValueOperations<String, String> opsValue = template.opsForValue();
		opsValue.set("name", "Barney");
		opsValue.set("email", "barney@email.com");
		
	}

}
