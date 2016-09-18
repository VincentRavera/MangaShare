package fr.drmobius.mangashare.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.drmobius.mangashare.model.Commentaire;

public interface CommentaireDAO {

	@Query("SELECT c FROM Commentaire c ORDER BY p.nom DESC")
	Commentaire getCommentaireById(Long id) throws DataAccessException;

	@Query("SELECT c FROM Commentaire c ORDER BY c.dateDuPost")
	List<Commentaire> getAllCommentaire() throws DataAccessException;

	@Query("SELECT c FROM Commentaire c left join c.manga m WHERE c.id=:id")
	List<Commentaire> getAllCommentaireByManga(@Param("id") Long id) throws DataAccessException;

	Commentaire save(Commentaire commentaire) throws DataAccessException;
	
	void remove(Commentaire commentaire) throws DataAccessException;
}
