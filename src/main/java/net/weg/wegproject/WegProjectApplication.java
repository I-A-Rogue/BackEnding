package net.weg.wegproject;

import net.weg.wegproject.util.BancoUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WegProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WegProjectApplication.class, args);
//		BancoUtil.createRandomMotors();
	}

}
