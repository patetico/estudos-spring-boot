package br.politec.laudos.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Hello World! Spring Boot!";
    }
}
