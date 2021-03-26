import { Component, OnInit } from '@angular/core';
import { Airport } from './model/airport';
import { Waypoint } from './model/waypoint';
import { AirportService } from './service/airport.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;

  airports: Airport[] = [];

  waypoints: Waypoint[] = [];
  
  constructor(private airportService: AirportService) {
    this.title = 'Spring Boot - Angular Application';
  }
  
  ngOnInit() {
    this.airportService.findAll().subscribe((data: Airport[]) => {
      this.airports = data;
    });
  }
  
  retrieveWaypointsFromSids(airportUid: string) {
	this.airportService.findWaypointsFromSids(airportUid).subscribe((data: Waypoint[]) => {
      this.waypoints  = data;
    });
  }
  
  retrieveWaypointsFromStars(airportUid: string) {
	this.airportService.findWaypointsFromStars(airportUid).subscribe((data: Waypoint[]) => {
      this.waypoints  = data;
    });
  }
  
}