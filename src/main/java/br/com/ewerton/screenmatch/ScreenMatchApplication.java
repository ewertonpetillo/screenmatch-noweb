package br.com.ewerton.screenmatch;

import br.com.ewerton.screenmatch.model.DadosSerie;
import br.com.ewerton.screenmatch.services.ConsumoAPI;
import br.com.ewerton.screenmatch.services.ConverteDados;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		ConverteDados converte = new ConverteDados();
		DadosSerie dados = converte.obterDados(json, DadosSerie.class);

		System.out.println(dados);

	}
}
