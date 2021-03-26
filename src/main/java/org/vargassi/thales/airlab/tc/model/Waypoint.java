package org.vargassi.thales.airlab.tc.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.base.MoreObjects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {
    
    private String uid;
    
    private String name;
    
    private BigDecimal lat;
    
    private BigDecimal lng;
    
    public Waypoint () {
        
    }
    
    public Waypoint(String uid, String name, BigDecimal lat, BigDecimal lng) {
        super();
        this.uid = uid;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uid", uid)
                .add("name", name)
                .add("lat", lat)
                .add("lng", lng)
                .toString();
    }
}