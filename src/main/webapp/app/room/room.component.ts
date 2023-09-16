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
  restaurants!: Restaurants[];
  alerts: any[] = [{}];
  formGroup!: FormGroup;

  constructor(
    private router: Router,
    private roomService: RoomService
  ) {}

  ngOnInit() {
    // this.restaurants = [
    //   { name: 'New York', code: 'NY' },
    //   { name: 'Rome', code: 'RM' },
    //   { name: 'London', code: 'LDN' },
    //   { name: 'Istanbul', code: 'IST' },
    //   { name: 'Paris', code: 'PRS' },
    // ];

    // this.formGroup = new FormGroup({
    //   selectedCity: new FormControl<restaurants | null>(null),
    // });
  }

  home() {
    this.router.navigate(['/home']);
  }

  submit() {}

  pick(): void {
    this.alerts.push({
      type: 'info',
      msg: `This alert will be closed in 5 seconds (added: ${new Date().toLocaleTimeString()})`,
      timeout: 5000,
    });
  }

  getRandomRestaurant() {
    // this.roomService.getRandomRestaurant().subscribe(
    //   (restaurants) => {
    //     // assuming 'name' is a field in the restaurants object
    //     this.alertService.showAlert(restaurants.name);
    //     this.alerts.push({
    //       type: 'info',
    //       msg: `This alert will be closed in 5 seconds (added: ${new Date().toLocaleTimeString()})`,
    //       timeout: 5000,
    //     });
    //   },
    //   (error) => {
    //     console.error('An error occurred:', error);
    //   }
    // );

    this.alerts.push({
      type: 'info',
      msg: `This alert will be closed in 5 seconds (added: ${new Date().toLocaleTimeString()})`,
      timeout: 5000,
    });
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter((alert) => alert !== dismissedAlert);
  }
}
