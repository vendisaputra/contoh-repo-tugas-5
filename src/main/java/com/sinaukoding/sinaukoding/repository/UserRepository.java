package com.sinaukoding.sinaukoding.repository;

import com.sinaukoding.sinaukoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByProfileNameContaining(String profileName);

    Integer countByProfileNameContaining(String name);
}
