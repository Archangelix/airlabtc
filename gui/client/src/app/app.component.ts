import { Component, OnInit } from '@angular/core';
import { Airport } from './model/airport';
import { Waypoint } from './model/waypoint';
import { AirportService } from './service/airport.service';
import { interval } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  airports: Airport[] = [];

  sidWaypoints: Waypoint[] = [];
  starWaypoints: Waypoint[] = [];
  
  highlightRow : Number = -1;  
  
  ClickedRow:any;
  
  icao: string = "";
  
  constructor(private airportService: AirportService) {
	this.ClickedRow = function(index: number) {
		this.highlightRow = index;
		this.icao = this.airports[index].uid
		this.retrieveWaypointsFromSids(this.icao);
		this.retrieveWaypointsFromStars(this.icao);
	}
	interval(3000).subscribe((val:any) => { 
		this.retrieveWaypointsFromSids(this.icao);
		this.retrieveWaypointsFromStars(this.icao);
	});
  }
  
  ngOnInit() {
    this.airportService.findAll().subscribe((data: Airport[]) => {
      this.airports = data;
    });
  }
  
  retrieveWaypointsFromSids(icao: string) {
	this.airportService.findWaypointsFromSids(icao).subscribe((data: Waypoint[]) => {
      this.sidWaypoints  = data;
    });
  }
  
  retrieveWaypointsFromStars(icao: string) {
	this.airportService.findWaypointsFromStars(icao).subscribe((data: Waypoint[]) => {
      this.starWaypoints  = data;
    });
  }
  
}