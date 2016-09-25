package fr.drmobius.mangashare.services;

import java.util.List;

import fr.drmobius.mangashare.model.Manga;

public interface MangaService {
	
	public List<Manga> findAll();
	
	public Manga findById(Long Id);
	
	public Manga save(Manga manga);
	
	public void delete(Long id);

}
