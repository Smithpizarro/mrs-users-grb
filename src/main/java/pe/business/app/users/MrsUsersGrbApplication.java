package pe.business.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("pe.business.app.users")
public class MrsUsersGrbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrsUsersGrbApplication.class, args);
	}

}
