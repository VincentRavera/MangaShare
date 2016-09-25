package fr.drmobius.mangashare.services.impl;

import java.util.List;

import fr.drmobius.mangashare.dao.MangaDAO;
import fr.drmobius.mangashare.model.Manga;
import fr.drmobius.mangashare.services.MangaService;

public class MangaServiceImpl implements MangaService {

    private MangaDAO mangaDAO;

    public MangaDAO getMangaDAO() {
        return mangaDAO;
    }

    public void setMangaDAO(MangaDAO mangaDAO) {
        this.mangaDAO = mangaDAO;
    }

    @Override
    public List<Manga> findAll() {
        return mangaDAO.findAllOrdred();
    }

    @Override
    public Manga findById(Long id) {
        return mangaDAO.findOne(id);
    }

    @Override
    public Manga save(Manga manga) {
        return mangaDAO.save(manga);
    }

    @Override
    public void delete(Long id) {
        mangaDAO.delete(id);
    }

}
