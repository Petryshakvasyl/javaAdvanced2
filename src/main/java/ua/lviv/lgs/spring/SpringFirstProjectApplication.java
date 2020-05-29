package ua.lviv.lgs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFirstProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringFirstProjectApplication.class, args);

	}

}
