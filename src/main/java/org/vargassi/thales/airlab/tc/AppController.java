package org.vargassi.thales.airlab.tc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vargassi.thales.airlab.tc.manager.AtmManager;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;

@RestController
@CrossOrigin
public class AppController {

    @Autowired
    private AtmManager atmManager;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings to Mr. Iwan from Spring Boot!";
    }

    @RequestMapping("/airports")
    public List<Airport> getAirports() {
        return atmManager.getAllAirports();
    }

    @RequestMapping("/waypoints/sid")
    public List<Waypoint> getWaypointsMostAssociatedToSids(@RequestParam("airportuid") String airportUid) {
        return atmManager.retrieveWaypointsMostAssociatedToSids(airportUid);
    }

    @RequestMapping("/waypoints/star")
    public List<Waypoint> getWaypointsMostAssociatedToStars(@RequestParam("airportuid") String airportUid) {
        return atmManager.retrieveWaypointsMostAssociatedToStars(airportUid);
    }

}