package org.vargassi.thales.airlab.tc.proxy;

import java.util.List;

import org.vargassi.thales.airlab.tc.model.Airport;

public interface AtmProxy {

    List<Airport> getAllAirports();

    List<Sid> retrieveSids(String airportUid);

    List<Star> retrieveStars(String airportUid);

}
