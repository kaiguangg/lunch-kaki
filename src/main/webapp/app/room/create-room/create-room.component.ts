import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { RoomService } from '../room.service';
import { CreateRoom } from '../room.model';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css'],
})
export class CreateRoomComponent {
  @Output() close = new EventEmitter();

  newItem: string = '';
  items: string[] = [];
  showError = false;
  errorMessage: string = '';

  constructor(private router: Router, private roomService: RoomService) {}

  addItem() {
    if (this.newItem) {
      this.items.push(this.newItem);
      this.newItem = '';
    }

    this.showError = false;
    this.errorMessage = '';
  }

  removeItem(index: number) {
    this.items.splice(index, 1);
  }

  validateInput(event: any) {
    const pattern = /^[0-9A-Za-z_\-'@ ]*$/;
    const inputChar = String.fromCharCode(event.charCode);
    if (!pattern.test(inputChar)) {
      // invalid character, prevent input
      event.preventDefault();
    }
  }

  filterInput(event: Event) {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9a-zA-Z_\- ' @&]/g, '');
  }

  reset() {
    this.items = [];
    this.newItem = '';
    this.showError = false;
    this.errorMessage = '';
  }

  submit() {
    if (this.items.length === 0) {
      this.showError = true;
      this.errorMessage = 'Please add a restaurant name.';
    }

    if (this.items.length > 0) {
      const payload: CreateRoom = {
        restaurants: this.items,
      };

      this.roomService.postRestaurants(payload).subscribe({
        next: (res) => {
          const roomId = res.body;
          console.log('Server Response: ', res.body);
          this.close.emit();
          this.router.navigate([`/room/${roomId}`], {
            state: { roomId: roomId },
          });
        },
        error: (error) => {
          this.showError = true;
          this.errorMessage = error.error;
        },
        complete: () => {},
      });
    }
  }

  closeDialog() {
    this.close.emit();
  }
}
