package br.com.esquentati.turistasjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TuristasjpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuristasjpApplication.class, args);
	}

}
