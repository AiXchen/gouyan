package com.gouyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Aixchen
 * @date 2024/1/24 17:41
 */
@ComponentScan(basePackages = {"com.anji.captcha", "com.gouyan"})
@SpringBootApplication
public class  GouyanAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GouyanAdminApplication.class, args);
	}

}
