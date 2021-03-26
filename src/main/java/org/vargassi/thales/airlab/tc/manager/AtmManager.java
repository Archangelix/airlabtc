package org.vargassi.thales.airlab.tc.manager;

import java.util.List;

import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;

public interface AtmManager {

    List<Airport> getAllAirports();

    List<Waypoint> retrieveWaypointsMostAssociatedToSids(String airportUid);

    List<Waypoint> retrieveWaypointsMostAssociatedToStars(String airportUid);

}
