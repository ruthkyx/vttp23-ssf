package nus.iss.d19pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class D19pmApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(D19pmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String filePath = "/Users/ruthie/Desktop/codes/vttp23/SSF/day19/employee2.json";

		File f = new File(filePath);
		InputStream is = new FileInputStream(f);

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = "";
		if ((line = br.readLine()) != null) {
			
		}
		
	}

}
