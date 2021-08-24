package br.com.esquentati.agendapasseios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgendapasseiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendapasseiosApplication.class, args);
	}

}
