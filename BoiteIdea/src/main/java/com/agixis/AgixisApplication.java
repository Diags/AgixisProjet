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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = { "com.agixis.idees.services", "com.agixis.idees.controller",
		"com.agixis.evenement.services", "com.agixis.evenement.controller" })
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
		List<Idea> ideas = Arrays.asList(new Idea("sylla", "toto@gmailµ.com", "bombons"),
				new Idea("bouna", "toto@gmailµ.com", "cococ"));
		List<Evenement> evenements = Arrays.asList(new Evenement("diouf", "toto@gmailµ.com"),
				new Evenement("Abdou", "toto@gmailµ.com"));

		ideas.stream().forEach(idea -> ideaRepository.save(idea));

		ideaRepository.findAll().stream().map(ide -> ide.getCreateBy()).forEach(System.out::println);
	System.out.println("***********************************************");
		evenements.stream().forEach(evenement -> evenementRepository.save(evenement));

		evenementRepository.findAll().stream().map(ide -> ide.getCreateBy()).forEach(System.out::println);

	}
}
