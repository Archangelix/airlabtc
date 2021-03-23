package org.vargassi.thales.airlab.tc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/")
    public String index() {
        return "Greetings to Iwan from Spring Boot!";
    }

}