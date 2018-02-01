package com.agixis.evenements.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agixis.evenements.entities.Evenement;
import com.agixis.evenements.repository.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementServiceRepo {
	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public List<Evenement> getAllEvents() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "dateEvenement");
		return evenementRepository.findAll(sortByCreatedAtDesc);
	}

	@Override
	public ResponseEntity<Evenement> getEventById(Long id) {
		Evenement searchEvent = evenementRepository.findOne(id);
		if (searchEvent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Evenement>(searchEvent, HttpStatus.OK);
		}

	}

	@Override
	public Evenement createEvent(Evenement event) {

		return evenementRepository.save(event);
	}

	@Override
	public ResponseEntity<Evenement> updateEvent(Long id, Evenement event) {
		Evenement eventSearch = evenementRepository.findOne(id);
		if (eventSearch == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		eventSearch.setCreateBy(event.getCreateBy());
		eventSearch.setDescription(event.getDescription());

		Evenement updateEvent = evenementRepository.save(eventSearch);

		return new ResponseEntity<Evenement>(updateEvent, HttpStatus.OK);
	}

	@Override
	public void deleteEvent(@NotNull Long id) {

		evenementRepository.delete(id);
	}

}
