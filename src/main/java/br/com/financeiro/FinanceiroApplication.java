package br.com.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"br.com.entities.bens", "br.com.entities.consultaCpf", "br.com.entities.divida", "br.com.entities.empresa", "br.com.entities.movimentacao", "br.com.entities.pessoa"})
@EntityScan({"br.com.entities.bens", "br.com.entities.consultaCpf", "br.com.entities.divida", "br.com.entities.empresa", "br.com.entities.movimentacao", "br.com.entities.pessoa"})
@EnableJpaRepositories({"br.com.entities.bens", "br.com.entities.consultaCpf", "br.com.entities.divida", "br.com.entities.empresa", "br.com.entities.movimentacao", "br.com.entities.pessoa"})
public class FinanceiroApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}
}
