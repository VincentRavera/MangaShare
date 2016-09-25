package fr.drmobius.mangashare.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.drmobius.mangashare.model.Manga;

public interface MangaDAO extends JpaRepository<Manga, Long> {

    List<Manga> findByNom(String nom) throws DataAccessException;

    List<Manga> findAll() throws DataAccessException;

    @Query("SELECT m FROM Manga m ORDER BY m.date")
    List<Manga> findAllOrdred() throws DataAccessException;

}
