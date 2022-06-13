package com.sinaukoding.sinaukoding.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserCustomeDTO {
    private Integer idUser;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private DetailUserCustomeDTO detailUser;
}