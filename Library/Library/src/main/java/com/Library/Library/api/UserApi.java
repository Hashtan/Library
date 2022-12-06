package com.Library.Library.api;

import com.Library.Library.dao.entity.User;
import com.Library.Library.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private UserManager userManager;

    @Autowired
    public UserApi(UserManager users) {
        this.userManager = users;
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userManager.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userManager.save(user);
    }
}