package fr.drmobius.mangashare.services.impl;

import fr.drmobius.mangashare.dao.GenreDAO;
import fr.drmobius.mangashare.services.GenreService;

public class GenreServiceImpl implements GenreService{
	
	private GenreDAO genreDAO;

	public GenreDAO getGenreDAO() {
		return genreDAO;
	}

	public void setGenreDAO(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}
	
	

}
