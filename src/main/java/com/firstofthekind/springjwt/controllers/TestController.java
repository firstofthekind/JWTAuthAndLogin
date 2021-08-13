package com.firstofthekind.springjwt.controllers;

import com.firstofthekind.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public String currentUserName(Principal principal) {
        return "Hello, " +
                userRepository.findByUsername(principal
                        .getName()).get().getFirstname();
    }

}
