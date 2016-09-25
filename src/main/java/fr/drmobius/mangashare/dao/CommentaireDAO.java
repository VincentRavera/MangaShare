package fr.drmobius.mangashare.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.drmobius.mangashare.model.Commentaire;

public interface CommentaireDAO extends JpaRepository<Commentaire, Long>{

	@Query("SELECT c FROM Commentaire c ORDER BY c.dateDuPost")
	List<Commentaire> findAllOrdered() throws DataAccessException;

	@Query("SELECT c FROM Commentaire c left join c.manga m WHERE c.id=:id Order by c.dateDuPost")
	List<Commentaire> getAllCommentaireByManga(@Param("id") Long id) throws DataAccessException;

}
