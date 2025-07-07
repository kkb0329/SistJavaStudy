package boot.day0703.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("data.thyme.*")
public class ThymeleafTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafTestApplication.class, args);
	}

}
