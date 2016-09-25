package fr.drmobius.mangashare.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.drmobius.mangashare.exception.JsonError;
import fr.drmobius.mangashare.exception.MangaNotFoundException;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = { DataAccessException.class, MangaNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void hadleDataAccessEcxeption(HttpServletResponse response, Exception e) throws IOException {
        JsonError error = new JsonError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage("Missing Manga ...!");
        String messerror = error.getMessage();
        response.getWriter().println(messerror);
    }

}
