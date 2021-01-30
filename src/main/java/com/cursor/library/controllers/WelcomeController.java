package com.cursor.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/helloworld")
    String helloWorld() {
        return "Hello world";
    }
}
