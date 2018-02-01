package com.agixis.idees.services;

import com.agixis.idees.entities.Idea;
import com.agixis.idees.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class IdeaServiceImp implements IdeaService {

	@Autowired
	IdeaRepository ideaRepository;

	@Override
	public List<Idea> getAllIdea() {

		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "dateCreation");
		return ideaRepository.findAll(sortByCreatedAtDesc);
	}

	@Override
	public ResponseEntity<Idea> getIdeaById(Long id) {
		Idea searchIdea = ideaRepository.findOne(id);
		if (searchIdea == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Idea>(searchIdea, HttpStatus.OK);
		}

	}

	@Override
	public Idea create(Idea ideaToCreate) {
		return ideaRepository.save(ideaToCreate);
	}

	@Override
	public ResponseEntity<Idea> update(Long id, Idea ideaToUpdate) {
		Idea ideaSearch = ideaRepository.findOne(id);
		if (ideaSearch == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ideaSearch.setCreateBy(ideaToUpdate.getCreateBy());
		ideaSearch.setDescription(ideaToUpdate.getDescription());
		ideaSearch.setEmail(ideaToUpdate.getEmail());
		ideaSearch.setLikes(ideaToUpdate.getLikes());
		Idea updateIdea = ideaRepository.save(ideaToUpdate);

		return new ResponseEntity<Idea>(updateIdea, HttpStatus.OK);
	}

	@Override
	public void delete(@NotNull Long id) {
		ideaRepository.delete(id);
	}

	@Override
	public ResponseEntity<Idea> like(Long id, Idea ideaToLike) {
		Idea ideaSearch = ideaRepository.findOne(id);
		if (ideaSearch == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ideaSearch.setCreateBy(ideaToLike.getCreateBy());
		ideaSearch.setDescription(ideaToLike.getDescription());
		ideaSearch.setEmail(ideaToLike.getEmail());
		ideaSearch.setLikes(ideaToLike.getLikes() + 1);

		Idea updateIdea = ideaRepository.save(ideaSearch);

		return new ResponseEntity<Idea>(updateIdea, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Idea> disLike(Long id, Idea ideaToDislike) {
		Idea ideaSearch = ideaRepository.findOne(id);
		if (ideaSearch == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ideaSearch.setCreateBy(ideaToDislike.getCreateBy());
		ideaSearch.setDescription(ideaToDislike.getDescription());
		ideaSearch.setEmail(ideaToDislike.getEmail());
		ideaSearch.setLikes(ideaToDislike.getLikes() + 1);

		Idea updateIdea = ideaRepository.save(ideaSearch);

		return new ResponseEntity<Idea>(updateIdea, HttpStatus.OK);
	}

}
