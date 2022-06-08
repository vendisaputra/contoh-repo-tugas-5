package com.sinaukoding.sinaukoding.service;

import com.sinaukoding.sinaukoding.entity.User;
import com.sinaukoding.sinaukoding.entity.dto.UserDTO;
import com.sinaukoding.sinaukoding.entity.mapping.UserMapping;
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

    public UserDTO save(UserDTO param){
        User user = repository.save(UserMapping.INSTANCE.toEntity(param));
        return UserMapping.INSTANCE.toDto(user);
    }

    public List<UserDTO> lihatSemuaData(){
        return UserMapping.INSTANCE.toUserDTOList(repository.findAll());
    }

    public List<UserDTO> findByProfileName(String param){
        return UserMapping.INSTANCE.toUserDTOList(repository.findByProfileNameContaining(param));
    }

    public UserDTO findById(Integer id){
        return UserMapping.INSTANCE.toDto(repository.findById(id).orElse(null));
    }

    public UserDTO updateData(UserDTO dto, Integer id){
        User referenceData = repository.findById(id).get();
        referenceData.setUsername(dto.getUsername() != null ? dto.getUsername() : referenceData.getUsername());
        referenceData.setProfileName(dto.getProfileName() != null ? dto.getProfileName() : referenceData.getProfileName());

        return UserMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteData(int id){
        User reference = repository.findById(id).orElse(null);

        if (reference != null) {
            repository.delete(reference);
            return true;
        }

        return false;
    }

    public Integer countData(String nama){
        if (nama != null){
            return repository.countByProfileNameContaining(nama);
        }

        return (int) repository.count();
    }
}
