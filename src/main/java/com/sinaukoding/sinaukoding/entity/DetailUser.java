package com.sinaukoding.sinaukoding.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "detail_user")
@Getter
@Setter
public class DetailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alamat")
    private String address;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

//    @ManyToMany
//    @JoinTable(
//            name = "user_detail_user",
//            joinColumns = @JoinColumn(name = "id_user"),
//            inverseJoinColumns = @JoinColumn(name = "id_detail_user")
//    )
//    private List<User> userList;

    @OneToMany(mappedBy = "detailUser")
    private List<UserDetailUser> userDetailUsers = new ArrayList<>();
}
