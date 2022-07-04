package com.example.blondiebytes.tutorial.Controller;

import com.example.blondiebytes.tutorial.Models.User;
import com.example.blondiebytes.tutorial.Repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @RequestMapping("/greet")
    public String getGreeting(){
        return "Hi Iam wrafalit and I like pizza";
    }

    @RequestMapping("/goodbye")
    public String getGoodbye(){
        return "Goodbye from Spring Boot";
    }

    @Autowired
    private UserRep userRepo;

    @GetMapping(value = "/users")
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String setUser(@RequestBody User user) {
        userRepo.save(user);
        return "Saved...";
    }

    @Transactional
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable(value = "id") long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted... user id "+id;
    }
}
