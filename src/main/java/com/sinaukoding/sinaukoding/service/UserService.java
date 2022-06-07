package com.sinaukoding.sinaukoding.service;

import com.sinaukoding.sinaukoding.entity.DetailUser;
import com.sinaukoding.sinaukoding.entity.User;
import com.sinaukoding.sinaukoding.repository.DetailUserRepository;
import com.sinaukoding.sinaukoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    DetailUserRepository detailUserRepository;

    public User save(User param) {
        User user = repository.save(param);

        if (!param.getDetailUserList().isEmpty()) {
            for (DetailUser detailUser : param.getDetailUserList()) {
                if (detailUser.getId() != null) {
                    detailUser = detailUserRepository.getReferenceById(detailUser.getId());
                    detailUser.setUser(param);
                } else {
                    detailUser.setUser(user);
                }

                detailUserRepository.save(detailUser);
            }
        }

        return user;
    }

    public List<User> lihatSemuaData() {
        return repository.findAll();
    }

    public List<User> findByProfileName(String param) {
        return repository.findByProfileNameContaining(param);
    }

    public User findById(Integer id) {
        return repository.findById(id).get();
    }

    public User updateData(User user, Integer id) {
        User referenceData = repository.findById(id).get();
        referenceData.setUsername(user.getUsername() != null ? user.getUsername() : referenceData.getUsername());
        referenceData.setProfileName(user.getProfileName() != null ? user.getProfileName() : referenceData.getProfileName());

        return repository.save(referenceData);
    }

    public boolean deleteData(int id) {
        User reference = repository.findById(id).orElse(new User());
        repository.delete(reference);

        reference = repository.findById(id).orElse(null);

        if (reference == null)
            return true;

        return false;
    }
}
