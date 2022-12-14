package com.vip.coders.controller;

import com.vip.coders.entity.User;
import com.vip.coders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
public class dashboardController {

   @Autowired
    private UserService userService;

    @PostMapping(path = "/apply")
    @CrossOrigin()
    public boolean apply(@RequestParam String fullName, @RequestParam String skills,
                         @RequestParam int experience, @RequestParam long userId,
                         @RequestParam String designation, @RequestParam String languages,
                         @RequestBody MultipartFile resume) throws IOException {
        return userService.apply(userId, fullName, skills, experience, designation, languages, resume);
    }
    @GetMapping(path = "/availableMentors")
    public List<User> availableMentors() {
        return userService.availableMentors();
    }

}
