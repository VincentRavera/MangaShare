package fr.drmobius.mangashare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.drmobius.mangashare.services.MangaService;
import fr.drmobius.mangashare.validator.MangaValidator;

@Controller
@RequestMapping(value="/personnes")
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
		this.mangaService=mangaService;
	}
	
	@RequestMapping(value="/index.html", method= RequestMethod.GET)
	public ModelAndView initIndex() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/listmanga.html", method= RequestMethod.GET)
	public ModelAndView initListManga(){
		ModelAndView modelAndView = new ModelAndView("list-mangas");
		return modelAndView;
	}

}
