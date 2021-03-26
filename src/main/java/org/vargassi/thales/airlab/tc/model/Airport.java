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
public class Airport {
    
    private String uid;
    
    private String name;
    
    private String icao;
    
    private BigDecimal lat;
    
    private BigDecimal lng;
    
    private int alt;
    
    private String iata;

    public Airport() {
        super();
    }

    public Airport(String name, BigDecimal coordinate) {
        super();
        this.uid = name;
        this.name = name;
        this.icao = name;
        this.lat = coordinate;
        this.lng = coordinate;
        this.alt = coordinate.intValue();
        this.iata = name;
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

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
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

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uid", uid)
                .add("name", name)
                .add("icao", icao)
                .add("lat", lat)
                .add("lng", lng)
                .add("alt", alt)
                .add("iata", iata)
                .toString();
    }
}
