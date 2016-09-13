package fr.drmobius.mangashare.services.impl;

import fr.drmobius.mangashare.dao.MangaDAO;
import fr.drmobius.mangashare.services.MangaService;

public class MangaServiceImpl implements MangaService{
	
	private MangaDAO mangaDAO;

	public MangaDAO getMangaDAO() {
		return mangaDAO;
	}

	public void setMangaDAO(MangaDAO mangaDAO) {
		this.mangaDAO = mangaDAO;
	}
	
	

}
