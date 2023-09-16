import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Restaurants } from './room.model';
import { AlertComponent } from 'ngx-bootstrap/alert';
import { Router } from '@angular/router';
import { RoomService } from './room.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css'],
})
export class RoomComponent implements OnInit {
  alerts: any[] = [{}];
  formGroup!: FormGroup;
  roomId!: number;
  restaurants?: Restaurants;
  restaurantName?: string = '';
  showError = false;
  errorMessage: string = '';

  constructor(private router: Router, private roomService: RoomService) {
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as { roomId: number };

    if (state) {
      this.roomId = state.roomId;
      console.log('state' + state.roomId); // Should log '1234' or whatever you passed as roomId
    }
  }

  ngOnInit() {
    console.log('onInit' + this.roomId);

    this.roomService.getAllRestaurants(this.roomId).subscribe(
      (res) => {
        if (res.body) {
          this.restaurants = res.body;
        }
        console.log('Room component Server Response: ', this.restaurants);
      },
      (error) => {
        console.error('Server Error: ', error);
      }
    );
  }

  home() {
    this.router.navigate(['/home']);
  }

  pick(): void {
    this.alerts.push({
      type: 'info',
      msg: `Restaurant to go for lunch : ${this.restaurantName})`,
      timeout: 5000,
    });
  }

  getRandomRestaurant() {
    this.alerts.shift();
    this.roomService.getRandomRestaurant(this.roomId).subscribe({
      next: (res) => {
        this.restaurantName = res.body;
        console.log('restuarnt name ' + res.body);
        this.alerts.push({
          type: 'info',
          msg: `Restaurant to go for lunch : ${this.restaurantName}`,
          timeout: 5000,
        });
      },
      error: (error) => {
        this.showError = true;
        this.errorMessage = error.error;
      },
      complete: () => {},
    });
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter((alert) => alert !== dismissedAlert);
  }
}
