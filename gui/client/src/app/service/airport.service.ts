import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Airport } from '../model/airport';
import { Observable } from 'rxjs';

@Injectable()
export class AirportService {

  private airportsUrl: string;

  constructor(private http: HttpClient) {
    this.airportsUrl = 'http://192.168.99.100:31090/airports';
  }

  public findAll(): Observable<Airport[]> {
    return this.http.get<Airport[]>(this.airportsUrl);
  }

}