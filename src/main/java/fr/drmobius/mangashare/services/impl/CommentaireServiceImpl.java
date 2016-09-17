package fr.drmobius.mangashare.services.impl;

import java.util.List;

import fr.drmobius.mangashare.dao.CommentaireDAO;
import fr.drmobius.mangashare.model.Commentaire;
import fr.drmobius.mangashare.services.CommentaireService;

public class CommentaireServiceImpl implements CommentaireService{
	
	private CommentaireDAO dao;

	public CommentaireDAO getCommentaireDAO() {
		return dao;
	}

	public void setCommentaireDAO(CommentaireDAO commentaireDAO) {
		this.dao = commentaireDAO;
	}

	@Override
	public Commentaire getCommentaireById(Long id) {
		return dao.getCommentaireById(id);
	}

	@Override
	public List<Commentaire> getAllCommentaire() {
		return dao.getAllCommentaire();
	}

	@Override
	public List<Commentaire> getAllCommentaireByManga(Long id) {
		return dao.getAllCommentaireByManga(id);
	}

	@Override
	public Commentaire createCommentaire(Commentaire com) {
		return dao.createCommentaire(com);
	}

	@Override
	public Commentaire updateCommentaire(Commentaire com) {
		return dao.updateCommentaire(com);
	}

	@Override
	public void removeCommentaire(Commentaire com) {
		dao.removeCommentaire(com);
	}
	
	
	

}
