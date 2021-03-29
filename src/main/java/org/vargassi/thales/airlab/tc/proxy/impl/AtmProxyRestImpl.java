package org.vargassi.thales.airlab.tc.proxy.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;
import org.vargassi.thales.airlab.tc.proxy.AtmProxy;
import org.vargassi.thales.airlab.tc.proxy.Sid;
import org.vargassi.thales.airlab.tc.proxy.Star;
import org.vargassi.thales.airlab.tc.util.Constants;

@Component
public class AtmProxyRestImpl implements AtmProxy {
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public List<Airport> getAllAirports() {
        List<Airport> result = new ArrayList<>();
        try {
            URL url = new URL(Constants.ATM_API_URL_AIRPORTS);
    
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("api-key", Constants.ATM_API_KEY);
    
            InputStream responseStream = connection.getInputStream();
    
            result = Arrays.asList(mapper.readValue(responseStream, Airport[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Sid> retrieveSids(String airportIcao) {
        try {
            URL url = new URL(Constants.ATM_API_URL_SIDS+"/"+airportIcao);
    
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("api-key", Constants.ATM_API_KEY);
    
            InputStream responseStream = connection.getInputStream();
    
            List<Sid> sids = Arrays.asList(mapper.readValue(responseStream, Sid[].class));
            if (sids==null) {
                return new ArrayList<>();
            }
            return sids;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Star> retrieveStars(String airportIcao) {
        try {
            URL url = new URL(Constants.ATM_API_URL_STARS+"/"+airportIcao);
    
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("api-key", Constants.ATM_API_KEY);
    
            InputStream responseStream = connection.getInputStream();
    
            List<Star> stars = Arrays.asList(mapper.readValue(responseStream, Star[].class));
            if (stars==null) {
                return new ArrayList<>();
            }
            return stars;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
