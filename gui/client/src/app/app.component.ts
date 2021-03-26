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

  sidWaypoints: Waypoint[] = [];
  starWaypoints: Waypoint[] = [];
  
  highlightRow : Number = 0;  
  
  ClickedRow:any;  
  
  constructor(private airportService: AirportService) {
    this.title = 'Spring Boot - Angular Application';
	this.ClickedRow = function(index: number) {
		var airportUid: string = this.airports[index].uid
		this.retrieveWaypointsFromSids(airportUid);
		this.retrieveWaypointsFromStars(airportUid);
	}  
  }
  
  ngOnInit() {
    this.airportService.findAll().subscribe((data: Airport[]) => {
      this.airports = data;
    });
  }
  
  retrieveWaypointsFromSids(airportUid: string) {
	this.airportService.findWaypointsFromSids(airportUid).subscribe((data: Waypoint[]) => {
      this.sidWaypoints  = data;
    });
  }
  
  retrieveWaypointsFromStars(airportUid: string) {
	this.airportService.findWaypointsFromStars(airportUid).subscribe((data: Waypoint[]) => {
      this.starWaypoints  = data;
    });
  }
  
}