import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ride } from '../models/ride.model';

@Injectable({
  providedIn: 'root'
})
export class RideService {
  private apiUrl = 'http://localhost:8080/api/rides';

  constructor(private http: HttpClient) {}

  postRide(ride: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/post`, ride);
  }

  getRidesByUser(emailid: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/user/${emailid}`);
  }
}