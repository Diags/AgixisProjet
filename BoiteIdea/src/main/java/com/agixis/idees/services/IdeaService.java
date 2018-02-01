package com.agixis.idees.services;

import com.agixis.idees.entities.Idea;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IdeaService {

	/**
	 * @return la liste de toutes les idées
	 */
	public List<Idea> getAllIdea();

	public ResponseEntity<Idea> getIdeaById(Long id);

	/**
	 * Permet de créer une nouvelle idée
	 *
	 * @param ideaToCreate
	 *            l'idée à créer
	 * @return la nouvelle idée qui a été créée
	 */
	public Idea create(Idea ideaToCreate);

	/**
	 * Permet de mettre à jour une idée
	 *
	 * @param ideaToUpdate
	 *            l'idée à mettre à jour
	 * @return idée qui a été modifiée
	 */
	public ResponseEntity<Idea> update(Long id, Idea ideaToUpdate);

	/**
	 * Permet de supprimer une idée
	 *
	 * @param ideaToDelete
	 *            l'idée à supprimer
	 */
	public void delete(Long id);

	/**
	 * Permet de d'incrémenter le conteur de like de idea passée en parametre
	 *
	 * @param ideaToLike
	 *            l'idée à "liker"
	 * @return le nombre le like total de @param ideaToLike
	 */
	public ResponseEntity<Idea> like(Long id, Idea ideaToLike);

	/**
	 * <p>
	 * Permet de décrémenter le conteur de like de idea passée en parametre
	 * </p>
	 *
	 * @param ideaToDislike
	 *            l'idée à "liker"
	 * @return le nombre le like total de @param ideaToDislike
	 */
	public ResponseEntity<Idea> disLike(Long id, Idea ideaToDislike);

}
