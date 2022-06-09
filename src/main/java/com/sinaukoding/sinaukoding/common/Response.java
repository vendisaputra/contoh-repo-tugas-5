package com.sinaukoding.sinaukoding.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer row;

    HttpStatus status;

    public Response(String message, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

    public Response(Object object, String message, HttpStatus httpStatus){
        this.data = object;
        this.message = message;
        this.status = httpStatus;
    }

    public Response(Object data, String message, Integer row, HttpStatus httpStatus) {
        this.data = data;
        this.message = message;
        this.row = row;
        this.status = httpStatus;
    }
}
