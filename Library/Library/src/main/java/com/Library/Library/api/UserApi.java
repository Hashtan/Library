package com.Library.Library.api;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.entity.User;
import com.Library.Library.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private UserManager users;

    @Autowired
    public UserApi(UserManager users) {
        this.users = users;
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return users.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return users.save(user);
    }
}