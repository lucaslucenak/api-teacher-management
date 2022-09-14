package com.lucaslucena.teachermanagement.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class StudentNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(String msg) {
        super();
    }
}
