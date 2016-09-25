package fr.drmobius.mangashare.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;

import fr.drmobius.mangashare.model.Manga;

public interface MangaDAO {

    Manga addManga(Manga manga);
    
    void removeManga(Manga manga);

    List<Manga> findByNom(String nom) throws DataAccessException;

    List<Manga> findAll() throws DataAccessException;

    @Query("SELECT m FROM Manga m ORDER BY m.date")
    List<Manga> findAllOrdred() throws DataAccessException;

    @Query("Select m FROM Manga m WHERE m.id=:id")
    Manga findById(Long id);

}
