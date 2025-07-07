package boot.my.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.data.*")
@MapperScan("boot.data.*")
public class BootMybatisEx5Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisEx5Application.class, args);
	}

}
