import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateRoom } from './room.model';

@Injectable({
  providedIn: 'root',
})
export class RoomService {
  private roomAPI = 'http://localhost:8080/api/room';
  private getRandomRestaurantAPI = 'http://localhost:8080/api/random-restaurant';

  constructor(private httpClient: HttpClient) {}

  getRandomRestaurant(roomId: number): Observable<any> {
    return this.httpClient.get(`${this.getRandomRestaurantAPI}/${roomId}`, {
      observe: 'response',
      responseType: 'text',
    });
  }

  getAllRestaurants(roomId: number): Observable<any> {
    return this.httpClient.get(`${this.roomAPI}/${roomId}`, {
      observe: 'response',
      responseType: 'json',
    });
  }

  postRestaurants(restaurants: CreateRoom): Observable<any> {
    return this.httpClient.post(this.roomAPI, restaurants, {
      observe: 'response',
      responseType: 'text',
    });
  }
}
