package fr.drmobius.mangashare.services.impl;

import fr.drmobius.mangashare.dao.CommentaireDAO;
import fr.drmobius.mangashare.services.CommentaireService;

public class CommentaireServiceImpl implements CommentaireService{
	
	private CommentaireDAO commentaireDAO;

	public CommentaireDAO getCommentaireDAO() {
		return commentaireDAO;
	}

	public void setCommentaireDAO(CommentaireDAO commentaireDAO) {
		this.commentaireDAO = commentaireDAO;
	}
	

}
