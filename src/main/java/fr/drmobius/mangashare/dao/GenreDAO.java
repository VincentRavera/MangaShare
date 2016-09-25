package fr.drmobius.mangashare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.drmobius.mangashare.model.Genre;

public interface GenreDAO extends JpaRepository<Genre, Long>{

}
