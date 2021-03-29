package org.vargassi.thales.airlab.tc.model.gui;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.vargassi.thales.airlab.tc.model.Waypoint;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuiWaypoints {
    
    private String icao;
    
    private Waypoint[] waypoints;

    public GuiWaypoints() {
        
    }
    
    public GuiWaypoints(String icao, Waypoint[] waypoints) {
        super();
        this.icao = icao;
        this.waypoints = waypoints;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public Waypoint[] getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(Waypoint[] waypoints) {
        this.waypoints = waypoints;
    }
    
}
