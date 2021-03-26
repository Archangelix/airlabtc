package org.vargassi.thales.airlab.tc.proxy;

import java.util.List;

import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.IContainWaypoints;
import org.vargassi.thales.airlab.tc.model.Waypoint;

public class Star implements IContainWaypoints {
    
    private String name;
    
    private Airport airport;
    
    private List<Waypoint> waypoints;

    public Star() {
        
    }
    
    public Star(String name, Airport airport, List<Waypoint> waypoints) {
        super();
        this.name = name;
        this.airport = airport;
        this.waypoints = waypoints;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }
    
}
