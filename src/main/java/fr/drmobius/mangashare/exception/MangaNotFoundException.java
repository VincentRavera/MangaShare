package fr.drmobius.mangashare.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class MangaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MangaNotFoundException(String message) {
        super(message);
    }

}
