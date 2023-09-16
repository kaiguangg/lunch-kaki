import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RoomService } from 'app/room/room.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  showDialog = false;
  showError = false;
  errorMessage: string = '';
  roomId?: number;
  constructor(private router: Router, private roomService: RoomService) {}

  onSubmit(form: NgForm) {
    if (!form.value.pin) {
      this.showError = true;
      this.errorMessage = 'You need to enter the room PIN.';
    } else {
      this.showError = false;
      this.errorMessage = '';

      this.roomService.getAllRestaurants(form.value.pin).subscribe({
        next: (res) => {
          if (res.body) {
            this.roomId = res.body.roomId;
            this.router.navigate([`/room/${this.roomId}`], {
              state: { roomId: this.roomId },
            });
          }
        },
        error: (error) => {
          this.showError = true;
          this.errorMessage = error.error;
        },
        complete: () => {},
      });
    }
  }

  showModal() {
    this.showDialog = true;
    this.showError = false;
    this.errorMessage = '';
  }

  closeModal() {
    this.showDialog = false;
    this.showError = false;
    this.errorMessage = '';
  }
}
