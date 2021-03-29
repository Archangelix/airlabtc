package org.vargassi.thales.airlab.tc.manager.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;
import org.vargassi.thales.airlab.tc.model.gui.GuiWaypoints;

public class AtmManagerITTest {

    private static final String AIRLABTC_AIRPORTS_URL = "http://192.168.99.100:31090/airports";
    
    private static final String AIRLABTC_WAYPOINTS_SID_URL = "http://192.168.99.100:31090/waypoints/sid";
    
    private static final String AIRLABTC_WAYPOINTS_STAR_URL = "http://192.168.99.100:31090/waypoints/star";
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @BeforeClass
    public static void initClass() throws IOException, InterruptedException {
        Thread.sleep(10000); // Make sure that the pod is ready.
    }

    @Test
    public void testGetAllAirports() throws IOException {
        URL url = new URL(AIRLABTC_AIRPORTS_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        List<Airport> sids = Arrays.asList(mapper.readValue(responseStream, Airport[].class));
        Assertions.assertFalse(sids.isEmpty());
    }
    
    @Test
    public void testGetWaypointsForAirportWsslBySid() throws IOException {
        URL url = new URL(AIRLABTC_WAYPOINTS_SID_URL+"?icao=WSSL");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        GuiWaypoints result = mapper.readValue(responseStream, GuiWaypoints.class);
        List<Waypoint> waypoints = Arrays.asList(result.getWaypoints());
        Assertions.assertFalse(waypoints.isEmpty());
    }
    
    @Test
    public void testGetWaypointsForAirportWsslByStar() throws IOException {
        URL url = new URL(AIRLABTC_WAYPOINTS_STAR_URL+"?icao=WSSL");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        GuiWaypoints result = mapper.readValue(responseStream, GuiWaypoints.class);
        List<Waypoint> waypoints = Arrays.asList(result.getWaypoints());
        Assertions.assertFalse(waypoints.isEmpty());
    }
    
}
