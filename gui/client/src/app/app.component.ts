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
  
  airportUid: string = "";
  
  constructor(private airportService: AirportService) {
	this.ClickedRow = function(index: number) {
		this.highlightRow = index;
		this.airportUid = this.airports[index].uid
		this.retrieveWaypointsFromSids(this.airportUid);
		this.retrieveWaypointsFromStars(this.airportUid);
	}
	interval(3000).subscribe((val:any) => { 
		this.retrieveWaypointsFromSids(this.airportUid);
		this.retrieveWaypointsFromStars(this.airportUid);
	});
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