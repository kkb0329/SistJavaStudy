package boot.mvc.hi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*"})  //와일드카드 가능
public class SpringBootEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx2Application.class, args);
	}

}
