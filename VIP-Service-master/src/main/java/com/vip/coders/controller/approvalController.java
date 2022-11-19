package com.vip.coders.controller;


import com.vip.coders.entity.User;
import com.vip.coders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class approvalController {

    @Autowired
    public UserService userService;

    @GetMapping(path = "/approveMentor")//3
    public boolean approveMentor(@RequestParam long userId, @RequestParam int rate) {
        return userService.approveMentor(userId, rate);
    }

    @GetMapping(path = "/downloadResume")//2
    public ResponseEntity<byte[]> downloadResume(@RequestParam long userId) {

        byte[] resume = userService.downloadResume(userId);
        String fileName = "resume.docx";

        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(resume.length);
        respHeaders.setContentType(new MediaType("text", "json"));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        return new ResponseEntity<>(resume, respHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/appliedMentors")//1
    public List<User> appliedMentorsUrl() {
        return userService.appliedMentors();
    }
}
