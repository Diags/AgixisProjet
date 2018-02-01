package com.agixis.evenements.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import com.agixis.evenements.entities.Evenement;

public interface EvenementServiceRepo {
	public List<Evenement> getAllEvents();

	public ResponseEntity<Evenement> getEventById(Long id);

	public Evenement createEvent(Evenement event);

	public ResponseEntity<Evenement> updateEvent(Long id, Evenement event);

	public void deleteEvent(@NotNull Long id);
}
