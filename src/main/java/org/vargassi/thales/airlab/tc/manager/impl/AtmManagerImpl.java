package org.vargassi.thales.airlab.tc.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vargassi.thales.airlab.tc.manager.AtmManager;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;
import org.vargassi.thales.airlab.tc.proxy.AtmProxy;
import org.vargassi.thales.airlab.tc.proxy.Sid;
import org.vargassi.thales.airlab.tc.proxy.Star;

@Component
public class AtmManagerImpl implements AtmManager {

    @Autowired
    private AtmProxy atmProxy;
    
    @Override
    public List<Airport> getAllAirports() {
        return atmProxy.getAllAirports();
    }

    @Override
    public List<Waypoint> retrieveWaypointsMostAssociatedToSids(String airportUid) {
        List<Sid> sids = atmProxy.retrieveSids(airportUid);
        if (sids==null || sids.isEmpty()) {
            return new ArrayList<>();
        }
        Sid star = sids.get(0);
        List<Waypoint> waypoints = star.getWaypoints();
        if (waypoints==null) {
            return new ArrayList<>();
        }
        return waypoints;
    }

    @Override
    public List<Waypoint> retrieveWaypointsMostAssociatedToStars(String airportUid) {
        List<Star> stars = atmProxy.retrieveStars(airportUid);
        if (stars==null || stars.isEmpty()) {
            return new ArrayList<>();
        }
        Star star = stars.get(0);
        List<Waypoint> waypoints = star.getWaypoints();
        if (waypoints==null) {
            return new ArrayList<>();
        }
        return waypoints;
    }
}
