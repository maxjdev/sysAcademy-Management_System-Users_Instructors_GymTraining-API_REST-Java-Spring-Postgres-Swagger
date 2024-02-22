package com.sysAcademy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maxdev
 */
@RestController
@RequestMapping("/")
@Tag(name = "Welcome ", description = "Welcome to the sysAcademy API")
public class WelcomeController {
    // Home
    @Operation(summary = "Welcome message")
    @GetMapping
    public String welcome() {
        return "-----> Welcome to API: |||---sysAcademy---|||";
    }
}