package com.agixis.evenements.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agixis.evenements.entities.Evenement;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EvenementControler {
	@Autowired
	private com.agixis.evenements.service.EvenementServiceRepo evenementServiceRepo;

	@GetMapping("/AllEvent")
	public List<Evenement> getAllEvents() {
		return evenementServiceRepo.getAllEvents();
	}

	@PostMapping("/EventCreate/{id}")
	public Evenement createEvent(@Valid @RequestBody Evenement event) {
		return evenementServiceRepo.createEvent(event);
	}

	@PutMapping("/UpdateEvent")
	public ResponseEntity<Evenement> updateEvent(@PathVariable("id") Long id, Evenement event) {
		return evenementServiceRepo.updateEvent(id, event);
	}

	@DeleteMapping(value = "/DeleteEvent/{id}")
	public void deleteEvent(@PathVariable("id") Long id) {
		evenementServiceRepo.deleteEvent(id);
	}
}
