package com.agixis.evenements.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import com.agixis.evenements.entities.Evenement;

public interface EvenementServiceRepo {
	/**
	 * 
	 * @return
	 */
	public List<Evenement> getAllEvents();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ResponseEntity<Evenement> getEventById(Long id);

	/**
	 * 
	 * @param event
	 * @return
	 */
	public Evenement createEvent(Evenement event);

	/**
	 * 
	 * @param id
	 * @param event
	 * @return
	 */
	public ResponseEntity<Evenement> updateEvent(Long id, Evenement event);

	/**
	 * 
	 * @param id
	 */
	public void deleteEvent(@NotNull Long id);
}
