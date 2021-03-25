package org.vargassi.thales.airlab.tc;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.proxy.AtmProxy;

@RestController
@CrossOrigin
public class AppController {

    @Autowired
    private AtmProxy atmProxy;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings to Mr. Iwan from Spring Boot!";
    }

    @RequestMapping("/airports")
    public List<Airport> getAirports(HttpServletResponse response) {
        return atmProxy.getAllAirports();
    }

}