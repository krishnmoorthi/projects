package com.kittyproject.myfarm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfarmApplication {
	
	 private static Logger logger = LogManager.getLogger(MyfarmApplication.class);

	public static void main(String[] args) {
		logger.info(" Starting MyFarm ");
		SpringApplication.run(MyfarmApplication.class, args);
	}
}
