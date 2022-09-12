package com.lucaslucena.teachermanagement.exceptions;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String msg) {
        super();
    }
}
