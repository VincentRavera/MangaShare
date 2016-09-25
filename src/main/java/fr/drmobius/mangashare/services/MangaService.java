package fr.drmobius.mangashare.services;

import java.util.List;

import fr.drmobius.mangashare.model.Manga;

public interface MangaService {
	
	public List<Manga> findAll();
	
	public Manga findById(Long Id);

}
