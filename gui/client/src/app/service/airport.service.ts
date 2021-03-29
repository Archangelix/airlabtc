import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Airport } from '../model/airport';
import { Waypoint } from '../model/waypoint';
import { IcaoAndWaypoints } from '../model/icaoAndWaypoints';
import { Observable } from 'rxjs';

@Injectable()
export class AirportService {

  private airportsUrl: string;

  private waypointsSidUrl: string;
  
  private waypointsStarUrl: string;

  constructor(private http: HttpClient) {
    this.airportsUrl = 'http://192.168.99.100:31090/airports';
    this.waypointsSidUrl = 'http://192.168.99.100:31090/waypoints/sid';
    this.waypointsStarUrl = 'http://192.168.99.100:31090/waypoints/star';
  }

  public findAll(): Observable<Airport[]> {
    return this.http.get<Airport[]>(this.airportsUrl);
  }

  public findWaypointsFromSids(icao: string): Observable<IcaoAndWaypoints> {
	return this.http.get<IcaoAndWaypoints>(this.waypointsSidUrl+'?icao='+icao);
  }

  public findWaypointsFromStars(icao: string): Observable<IcaoAndWaypoints> {
	return this.http.get<IcaoAndWaypoints>(this.waypointsStarUrl+'?icao='+icao);
  }
}