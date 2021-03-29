package org.vargassi.thales.airlab.tc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vargassi.thales.airlab.tc.manager.AtmManager;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;
import org.vargassi.thales.airlab.tc.model.gui.GuiWaypoints;

@RestController
@CrossOrigin
public class AppController {

    @Autowired
    private AtmManager atmManager;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings to Mr. Gabriel, Herve, and Florent from Spring Boot!";
    }

    @RequestMapping("/airports")
    public List<Airport> getAirports() {
        return atmManager.getAllAirports();
    }

    @RequestMapping("/waypoints/sid")
    public GuiWaypoints getWaypointsMostAssociatedToSids(@RequestParam("icao") String icao) {
        List<Waypoint> list = atmManager.retrieveWaypointsMostAssociatedToSids(icao);
        return new GuiWaypoints(icao, list.toArray(new Waypoint[list.size()]));
    }

    @RequestMapping("/waypoints/star")
    public GuiWaypoints getWaypointsMostAssociatedToStars(@RequestParam("icao") String icao) {
        List<Waypoint> list = atmManager.retrieveWaypointsMostAssociatedToStars(icao);
        return new GuiWaypoints(icao, list.toArray(new Waypoint[list.size()]));
    }

    @RequestMapping("/counters/inc")
    public void increaseCounter() {
        atmManager.increaseCounter();
    }

    @RequestMapping("/counters/dec")
    public void decreaseCounter() {
        atmManager.decreaseCounter();
    }

}