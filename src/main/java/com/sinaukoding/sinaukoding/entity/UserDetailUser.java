package com.sinaukoding.sinaukoding.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_detail_user")
@Getter
@Setter
public class UserDetailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_detail_user")
    private DetailUser detailUser;
//
//    @Column(name = "contoh")
//    private String contoh;
}
