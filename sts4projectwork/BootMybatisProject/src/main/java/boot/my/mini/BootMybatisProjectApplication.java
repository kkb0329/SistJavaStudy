package boot.my.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.data.*")
@MapperScan("boot.data.mapper")
public class BootMybatisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisProjectApplication.class, args);
	}

}
