package fr.drmobius.mangashare.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.drmobius.mangashare.model.Manga;

public class MangaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Manga.class);
	}

	@Override
	public void validate(Object target, Errors error) {
		Manga manga = (Manga) target;
		
		if (manga.getNom() == null || manga.getNom().isEmpty()) {
			error.rejectValue("nom", "nom.empty");
		}
	}

}
