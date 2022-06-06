package com.sinaukoding.sinaukoding.controller;

import com.sinaukoding.sinaukoding.Response;
import com.sinaukoding.sinaukoding.entity.User;
import com.sinaukoding.sinaukoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping()
    public User saveUser(@RequestBody User param) {
        return service.save(param);
    }

    @GetMapping()
    public Response findAll() {
        return new Response(service.lihatSemuaData(), "Data Berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-profile-name")
    public List<User> findByProfileName(@RequestParam(value = "profile-name") String profileName,
                                        @RequestParam(value = "username", required = false) String username) {
        return service.findByProfileName(profileName);
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    public User updateData(@RequestBody User param, @PathVariable int id) {
        return service.updateData(param, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteData(@PathVariable int id) {
        if (service.deleteData(id)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }


}
