package com.marzouka.BetriebsstellenDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BetriebsstellenDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetriebsstellenDbApplication.class, args);
	}

}
