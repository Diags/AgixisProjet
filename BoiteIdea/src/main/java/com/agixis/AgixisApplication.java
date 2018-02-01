package com.agixis;

import com.agixis.evenements.entities.Evenement;
import com.agixis.evenements.repository.EvenementRepository;
import com.agixis.idees.entities.Idea;
import com.agixis.idees.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = { "com.agixis.idees.services","com.agixis.idees.controller","com.agixis.evenement.services","com.agixis.evenement.controller" })
@EntityScan("com.agixis")
@EnableJpaRepositories("com.agixis")
public class AgixisApplication implements CommandLineRunner {

	@Autowired
	private IdeaRepository ideaRepository;

	@Autowired
	private EvenementRepository evenementRepository;
	public static void main(String[] args) {
		SpringApplication.run(AgixisApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Stream.of("bonjour", "comment").forEach(idea -> evenementRepository.save(new Evenement(idea, idea)));
		evenementRepository.findAll().stream().forEach(System.out::println);
		
		Stream.of("bonjour", "comment").forEach(idea -> ideaRepository.save(new Idea(idea, "tot@gmail.com", idea)));
		ideaRepository.findAll().stream().forEach(System.out::println);

	}
}
