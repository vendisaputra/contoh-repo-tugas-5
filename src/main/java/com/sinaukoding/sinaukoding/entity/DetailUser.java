package com.sinaukoding.sinaukoding.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detail_user")
@Setter
@Getter
public class DetailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alamat")
    private String address;

}
