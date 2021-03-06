package fr.drmobius.mangashare.exception;

import java.io.Serializable;

public class JsonError implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
