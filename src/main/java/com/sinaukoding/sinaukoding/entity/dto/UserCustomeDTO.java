package com.sinaukoding.sinaukoding.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinaukoding.sinaukoding.entity.DetailUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserCustomeDTO {
    private Integer idUser;
    private String username;
    private String profileName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private DetailUserCustomeDTO detailUser;
}