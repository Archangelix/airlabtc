package org.vargassi.thales.airlab.tc.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {
    
    private String uid;
    
    private String name;
    
    private BigDecimal lat;
    
    private BigDecimal lng;
    
    private int count;
    
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uid", uid)
                .add("name", name)
                .add("lat", lat)
                .add("lng", lng)
                .add("count", count)
                .toString();
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getUid(), getName(), getLat(), getLng());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Waypoint obj = (Waypoint) o;
        return Objects.equal(getUid(), obj.getUid()) 
                && Objects.equal(getName(), obj.getName())
                && Objects.equal(getLat(), obj.getLat())
                && Objects.equal(getLng(), obj.getLng());
    }

}
