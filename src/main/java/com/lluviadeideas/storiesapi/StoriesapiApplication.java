package com.lluviadeideas.storiesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class StoriesapiApplication {

	public static void main(String[] args) {
		
		 Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    System.setProperty("DB_URL", dotenv.get("DB_URL"));
    System.setProperty("DB_USER", dotenv.get("DB_USER"));
    System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

		SpringApplication.run(StoriesapiApplication.class, args);
	}

}
