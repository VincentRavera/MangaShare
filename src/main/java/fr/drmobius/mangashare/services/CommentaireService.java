package fr.drmobius.mangashare.services;

import java.util.List;

import fr.drmobius.mangashare.model.Commentaire;

public interface CommentaireService {
	
	public Commentaire getCommentaireById(Long id);
	
	public List<Commentaire> getAllCommentaire();
	
	public List<Commentaire> getAllCommentaireByManga(Long id);
	
	public Commentaire createCommentaire(Commentaire com);
	
	public Commentaire updateCommentaire(Commentaire com);
	
	public void removeCommentaire(Commentaire com);
	

}
