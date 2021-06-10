package com.example.TwitchBudgetTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TwitchBudgetToolApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(TwitchBudgetToolApplication.class, args);

		Connect.sayHey();
	}

}
