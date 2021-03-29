package org.vargassi.thales.airlab.tc.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vargassi.thales.airlab.tc.manager.AtmManager;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.IContainWaypoints;
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

    private int counter = 0;
    
    @Override
    public List<Waypoint> retrieveWaypointsMostAssociatedToSids(String airportIcao) {
        if (airportIcao==null || airportIcao.isEmpty()) {
            return Lists.newArrayList();
        }
        airportIcao = airportIcao.toUpperCase();
        List<Sid> sids = atmProxy.retrieveSids(airportIcao);
        return extractTwoMostAssociatedWaypoints(sids);
    }

    @Override
    public List<Waypoint> retrieveWaypointsMostAssociatedToStars(String airportIcao) {
        if (airportIcao==null || airportIcao.isEmpty()) {
            return Lists.newArrayList();
        }
        airportIcao = airportIcao.toUpperCase();
        List<Star> stars = atmProxy.retrieveStars(airportIcao);
        return extractTwoMostAssociatedWaypoints(stars);
    }
    
    private List<Waypoint> extractTwoMostAssociatedWaypoints(List<? extends IContainWaypoints> sids) {
        if (sids==null || sids.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Waypoint, Integer> counterMapOfWaypoints = extractCounterMap(sids);
        
        // Manipulate counters just for testing.
        for (Map.Entry<Waypoint, Integer> entry: counterMapOfWaypoints.entrySet()) {
            entry.setValue(entry.getValue()+counter);
        }
        
        List<Waypoint> result = new ArrayList<>();
        Optional<Waypoint> hottestWp = findAndRemoveHottestWaypoint(counterMapOfWaypoints);
        if (hottestWp.isPresent()) {
            result.add(hottestWp.get());
        } else {
            return result;
        }
        
        hottestWp = findAndRemoveHottestWaypoint(counterMapOfWaypoints);
        if (hottestWp.isPresent()) {
            result.add(hottestWp.get());
        } else {
            return result;
        }
        
        return result;
    }

    private Map<Waypoint, Integer> extractCounterMap(List<? extends IContainWaypoints> objects) {
        Map<Waypoint, Integer> counterMapOfWaypoints = new HashMap<>();
        for (IContainWaypoints obj: objects) {
            List<Waypoint> waypoints = obj.getWaypoints();
            for (Waypoint wp: waypoints) {
                Integer count = 1;
                if (counterMapOfWaypoints.containsKey(wp)) {
                    count = counterMapOfWaypoints.get(wp) + 1;
                }
                counterMapOfWaypoints.put(wp, count);
            }
        }
        return counterMapOfWaypoints;
    }
    
    private Optional<Waypoint> findAndRemoveHottestWaypoint(Map<Waypoint, Integer> map) {
        if (map.isEmpty()) {
            return Optional.empty();
        }
        
        Collection<Integer> counters = map.values();
        int maxCounter = counters.stream().mapToInt(Integer::valueOf).max().getAsInt();
        Optional<Waypoint> hottestWp = map.entrySet().stream()
                .filter(entry -> entry.getValue()==maxCounter)
                .map(entry -> entry.getKey())
                .findFirst();
        if (hottestWp.isPresent()) {
            map.remove(hottestWp.get());
            hottestWp.get().setCount(maxCounter);
        }
        return hottestWp;
    }

    @Override
    public void increaseCounter() {
        counter++;
    }

    @Override
    public void decreaseCounter() {
        counter--;
    }

}
