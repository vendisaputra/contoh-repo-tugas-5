package com.sinaukoding.sinaukoding.entity.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class UserDTO {
    private Integer idUser;
    private String username;
    private String profileName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private UserDetailDTO detailUser;
}
