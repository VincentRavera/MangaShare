package fr.drmobius.mangashare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.drmobius.mangashare.model.Manga;
import fr.drmobius.mangashare.services.MangaService;
import fr.drmobius.mangashare.validator.MangaValidator;

@Controller
@RequestMapping(value = "/personnes")
public class MangaController {

    private final Logger LOGGER = LoggerFactory.getLogger(MangaController.class);

    private MangaValidator mangaValidator;

    @Autowired
    private MangaService mangaService;

    @Autowired
    public void setMangaValidator(MangaValidator mangaValidator) {
        this.mangaValidator = mangaValidator;
    }

    @InitBinder
    public void init(WebDataBinder bind) {
        bind.setValidator(mangaValidator);
    }

    public void setMangaDervice(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView initIndex() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("MangaController::initIndex() called");
        }
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView initListManga() {
        ModelAndView modelAndView = new ModelAndView("list-mangas");
        List<Manga> listMangas = mangaService.findAll();
        modelAndView.addObject("mangas", listMangas);
        return modelAndView;
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
    public ModelAndView initFromManga(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("manga");
        Manga manga;
        if (id != null) {
            manga = mangaService.findById(id);
        } else {
            manga = new Manga();
        }
        modelAndView.addObject("manga", manga);
        return modelAndView;
    }

    @RequestMapping(value = "/add.html", method = RequestMethod.POST)
    public ModelAndView savePersonne(@ModelAttribute("manga") @Validated Manga manga, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("manga");
            modelAndView.addObject("manga", manga);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:list.html");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("" + manga.getNom() + manga.getUrl() + manga.getId());
        }
        mangaService.save(manga);
        return modelAndView;
    }
    

    @RequestMapping(value="/delete.html", method=RequestMethod.GET)
    public ModelAndView deletePersonne(@RequestParam(value="id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:list.html");
        mangaService.delete(id);
        return modelAndView;
    }

}
