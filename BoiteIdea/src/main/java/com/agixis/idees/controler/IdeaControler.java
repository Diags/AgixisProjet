package com.agixis.idees.controler;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.agixis.idees.entities.Idea;
import com.agixis.idees.services.IdeaService;

@RestController
@RequestMapping("/api")
public class IdeaControler {
	@Autowired
	private IdeaService ideaRepoService;

	@GetMapping("/AllIdea")
	public List<Idea> getAllIdea() {
		return ideaRepoService.getAllIdea();
	}

	@GetMapping("/Idea/{id}")
	public ResponseEntity<Idea> getIdeaById(@PathVariable("id") Long id) {
		return ideaRepoService.getIdeaById(id);
	}

	@PostMapping("/CreateIdea")
	@ResponseBody
	public Idea create(@Valid @RequestBody Idea ideaToCreate) {
		return ideaRepoService.create(ideaToCreate);
	}

	@PutMapping("/UpdateIdea/{id}")
	public ResponseEntity<Idea> update(@PathVariable("id") Long id, @Valid @RequestBody Idea ideaToUpdate) {
		return ideaRepoService.update(id, ideaToUpdate);
	}

	@DeleteMapping("/DeleteIdea/{id}")
	public void delete(@NotNull @PathVariable("id") Long id) {
		ideaRepoService.delete(id);
	}
}
