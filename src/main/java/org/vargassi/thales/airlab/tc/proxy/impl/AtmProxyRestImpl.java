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
import org.vargassi.thales.airlab.tc.proxy.AtmProxy;
import org.vargassi.thales.airlab.tc.util.Constants;

@Component
public class AtmProxyRestImpl implements AtmProxy {
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public List<Airport> getAllAirports() {
        List<Airport> result = new ArrayList<>();
        try {
            URL url = new URL(Constants.ATM_API_URL);
    
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
    
}
