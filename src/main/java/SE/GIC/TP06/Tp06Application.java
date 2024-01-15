package SE.GIC.TP06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "SE.GIC.TP06.repository")
@ComponentScan(basePackages = "SE.GIC.TP06")
public class Tp06Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp06Application.class, args);
	}

}
