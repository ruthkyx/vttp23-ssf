package sg.edu.nus.iss.day13work;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13workApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day13workApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			File fileDir = new File(dataDir);

			if(!fielDir.exists()) {
				fileDir.mkdir();
				System.out.println("***" + fileDir.getAbsolutePath());
				System.out.println("***" + fileDir.getPath());
				aystem.out.println("***" + fileDir.getParent());
			} else {
				System.out.println(fileDir.getAbsolutePath());
			}
		}
	}
}
