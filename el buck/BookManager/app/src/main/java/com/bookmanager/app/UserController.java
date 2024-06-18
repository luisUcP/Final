package com.bookmanager.app;

import com.bookmanager.app.domain.Book;
import com.bookmanager.app.domain.User;
import com.bookmanager.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.edit(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.edit(id);
    }

    @PostMapping("/lendBook")
    public List<Book> lendBook(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String author,
                               @RequestParam(required = false) String genre) {
        return userService.lendBook(title, author, genre);
    }
}

