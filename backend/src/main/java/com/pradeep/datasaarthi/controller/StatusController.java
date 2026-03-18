package com.pradeep.datasaarthi.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "OK";
    }
}
