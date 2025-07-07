package boot.mvc.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.*"})
public class SpringBootQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuizApplication.class, args);
	}

}
