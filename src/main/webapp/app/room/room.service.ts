import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RoomService {
  private getRandomRestaurantAPI = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  getRandomRestaurant(): Observable<any> {
    // Assuming the API endpoint for getting a random restaurants is 'random-restaurants'
    return this.http.get<any>(`${this.getRandomRestaurantAPI}random-restaurants`);
  }
}
