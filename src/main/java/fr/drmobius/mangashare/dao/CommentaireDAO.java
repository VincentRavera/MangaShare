package fr.drmobius.mangashare.dao;

import java.util.List;

import fr.drmobius.mangashare.model.Commentaire;

public interface CommentaireDAO {

	Commentaire getCommentaireById(Long id);

	List<Commentaire> getAllCommentaire();

	List<Commentaire> getAllCommentaireByManga(Long id);

	Commentaire createCommentaire(Commentaire com);

	Commentaire updateCommentaire(Commentaire com);

	void removeCommentaire(Commentaire com);

}
