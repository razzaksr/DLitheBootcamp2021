package application.ebuddy.dlithe.bootcamp.DLitheEbuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DLitheEbuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DLitheEbuddyApplication.class, args);
	}

}
