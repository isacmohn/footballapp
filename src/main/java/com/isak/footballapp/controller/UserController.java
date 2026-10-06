package com.isak.footballapp.controller;
import com.isak.footballapp.entity.User;
import com.isak.footballapp.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users") 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

@GetMapping
public List<User> findAll() {
    return userService.findAll();
}

//findUserById finner en bruker etter brukerId
@GetMapping("/user/{id}")
public User findUserById(@PathVariable Long id){
    return userService.findUserById(id);
}

//findUserByName finner bruker etter brukerNavn.
@GetMapping("/username/{userName}")
public User findUserByName(@PathVariable String userName){
    return userService.findUserByName(userName);
}

//deleteUserByName sletter bruker etter brukerNavn
@DeleteMapping("/username/{userName}")
public User deleteUserByName(@PathVariable String userName){
    return userService.deleteUserByName(userName);
}


//updateUserByName oppdaterer bruker etter brukerNavn
@PutMapping("/username/{userName}")
public User updateUserByName(
        @PathVariable String userName,
        @RequestBody User user){

    return userService.updateUserByName(userName, user);
}

//deleeeUserById sletter bruker etter brukerId
@DeleteMapping("/{id}")
public User deleteUserById(@PathVariable Long id){
    return userService.deleteUserById(id);
}

}
