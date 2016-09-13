package fr.drmobius.mangashare.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.drmobius.mangashare.dao.GenreDAO;
import fr.drmobius.mangashare.dao.MangaDAO;
import fr.drmobius.mangashare.services.GenreService;
import fr.drmobius.mangashare.services.MangaService;
import fr.drmobius.mangashare.services.impl.GenreServiceImpl;
import fr.drmobius.mangashare.services.impl.MangaServiceImpl;

@Configuration
@Import(value = { DataConfiguration.class , SecurityConfiguration.class})
@PropertySource(value = "classpath:/config.properties")
public class ApplicationConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	@Bean
	public MangaService mangaService(MangaDAO mangaDAO){
		MangaServiceImpl mangaServiceImpl = new MangaServiceImpl();
		mangaServiceImpl.setMangaDAO(mangaDAO);
		return mangaServiceImpl;
	}
	
	@Bean
	public GenreService genreService(GenreDAO genreDAO){
		GenreServiceImpl genreServiceImpl = new GenreServiceImpl();
		genreServiceImpl.setGenreDAO(genreDAO);
		return genreServiceImpl;
	}
	
	

}
