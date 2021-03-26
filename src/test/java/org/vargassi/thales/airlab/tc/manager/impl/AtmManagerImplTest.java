package org.vargassi.thales.airlab.tc.manager.impl;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.vargassi.thales.airlab.tc.model.Airport;
import org.vargassi.thales.airlab.tc.model.Waypoint;
import org.vargassi.thales.airlab.tc.proxy.AtmProxy;
import org.vargassi.thales.airlab.tc.proxy.Sid;
import org.vargassi.thales.airlab.tc.proxy.Star;

@RunWith(MockitoJUnitRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AtmManagerImplTest {

    @Mock
    private AtmProxy atmProxy;
    
    @InjectMocks
    private AtmManagerImpl atmManager;
    
    private static final String SID1 = "SID1";
    
    private static final String SID2 = "SID2";
    
    private static final String SID3 = "SID3";
    
    private static final String SID4 = "SID4";
    
    private static final String SID5 = "SID5";
    
    private static final String STAR1 = "STAR1";
    
    private static final String STAR2 = "STAR2";
    
    private static final String STAR3 = "STAR3";
    
    private static final String STAR4 = "STAR4";
    
    private static final String STAR5 = "STAR5";
    
    private static final String WSSS = "WSSS";
    
    private static final BigDecimal WSSS_COORD = new BigDecimal(0);
    
    private static final Airport AIRPORT_WSSS = new Airport(WSSS, WSSS_COORD);
    
    private static final String WP1_NAME = "WP1";
    
    private static final BigDecimal WP1_COORD = new BigDecimal(1);
    
    private static final String WP2_NAME = "WP2";
    
    private static final BigDecimal WP2_COORD = new BigDecimal(2);
    
    private static final String WP3_NAME = "WP3";
    
    private static final BigDecimal WP3_COORD = new BigDecimal(3);
    
    private static final Waypoint WP1 = new Waypoint(WP1_NAME, WP1_NAME, WP1_COORD, WP1_COORD);
    
    private static final Waypoint WP2 = new Waypoint(WP2_NAME, WP2_NAME, WP2_COORD, WP2_COORD);
    
    private static final Waypoint WP3 = new Waypoint(WP3_NAME, WP3_NAME, WP3_COORD, WP3_COORD);
    
    private static final Sid SID_1 = new Sid(SID1, AIRPORT_WSSS, Lists.newArrayList(WP2));
    
    private static final Sid SID_2 = new Sid(SID2, AIRPORT_WSSS, Lists.newArrayList(WP1, WP2));
    
    private static final Sid SID_3 = new Sid(SID3, AIRPORT_WSSS, Lists.newArrayList(WP1, WP2, WP3));
    
    private static final Sid SID_4 = new Sid(SID4, AIRPORT_WSSS, Lists.newArrayList(WP2));
    
    private static final Sid SID_5 = new Sid(SID5, AIRPORT_WSSS, Lists.newArrayList(WP3));
    
    private static final Star STAR_1 = new Star(STAR1, AIRPORT_WSSS, Lists.newArrayList(WP2));
    
    private static final Star STAR_2 = new Star(STAR2, AIRPORT_WSSS, Lists.newArrayList(WP1, WP2));
    
    private static final Star STAR_3 = new Star(STAR3, AIRPORT_WSSS, Lists.newArrayList(WP1, WP2, WP3));
    
    private static final Star STAR_4 = new Star(STAR4, AIRPORT_WSSS, Lists.newArrayList(WP2));
    
    private static final Star STAR_5 = new Star(STAR5, AIRPORT_WSSS, Lists.newArrayList(WP3));
    
    @Test
    public void testRetrieveWaypointForSidNominal() {
        List<Sid> sids = Lists.newArrayList(SID_1, SID_2, SID_3);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveSids(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToSids(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList(WP2, WP1);
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForSidEmpty() {
        List<Sid> sids = Lists.newArrayList();
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveSids(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToSids(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList();
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForSidOnlyOne() {
        List<Sid> sids = Lists.newArrayList(SID_1, SID_4);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveSids(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToSids(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList(WP2);
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForSidMoreThanTwo() {
        List<Sid> sids = Lists.newArrayList(SID_2, SID_3, SID_5);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveSids(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToSids(airportUid);
        
        Assertions.assertTrue(actualWaypoints.contains(WP1) && actualWaypoints.contains(WP2) || 
                actualWaypoints.contains(WP2) && actualWaypoints.contains(WP3) ||
                actualWaypoints.contains(WP1) && actualWaypoints.contains(WP3)
                );
    }

    @Test
    public void testRetrieveWaypointForStarNominal() {
        List<Star> sids = Lists.newArrayList(STAR_1, STAR_2, STAR_3);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveStars(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToStars(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList(WP2, WP1);
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForStarEmpty() {
        List<Star> sids = Lists.newArrayList();
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveStars(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToStars(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList();
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForStarOnlyOne() {
        List<Star> sids = Lists.newArrayList(STAR_1, STAR_4);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveStars(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToStars(airportUid);
        
        List<Waypoint> expectedWaypoints = Lists.newArrayList(WP2);
        Assertions.assertEquals(expectedWaypoints, actualWaypoints);
    }

    @Test
    public void testRetrieveWaypointForStarMoreThanTwo() {
        List<Star> sids = Lists.newArrayList(STAR_2, STAR_3, STAR_5);
        
        String airportUid = AIRPORT_WSSS.getUid();
        when(atmProxy.retrieveStars(airportUid)).thenReturn(sids);
        List<Waypoint> actualWaypoints = atmManager.retrieveWaypointsMostAssociatedToStars(airportUid);
        
        Assertions.assertTrue(actualWaypoints.contains(WP1) && actualWaypoints.contains(WP2) || 
                actualWaypoints.contains(WP2) && actualWaypoints.contains(WP3) ||
                actualWaypoints.contains(WP1) && actualWaypoints.contains(WP3)
                );
    }

}
