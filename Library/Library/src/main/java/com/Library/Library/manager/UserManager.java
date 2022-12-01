package com.Library.Library.manager;

import com.Library.Library.dao.entity.User;
import com.Library.Library.dao.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {
    private UserRepo userRepo;

    @Autowired
    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findById (Long id){
        return userRepo.findById(id);
    }
    public Iterable<User> findAll (){
        return userRepo.findAll();
    }
    public User save (User user){
        return userRepo.save(user);
    }
    public void deleteById (Long id){
        userRepo.deleteById(id);
    }
}
