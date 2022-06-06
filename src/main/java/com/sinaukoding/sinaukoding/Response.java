package com.sinaukoding.sinaukoding;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class Response implements Serializable {
    Object data;
    String message;
    HttpStatus status;

    public Response(Object object, String message, HttpStatus httpStatus){
        this.data = object;
        this.message = message;
        this.status = httpStatus;
    }
}
