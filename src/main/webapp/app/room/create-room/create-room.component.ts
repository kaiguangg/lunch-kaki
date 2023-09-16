import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css'],
})
export class CreateRoomComponent {
  @Output() close = new EventEmitter();

  newItem: string = '';
  items: string[] = [];
  
  constructor(private router: Router) { }
  
  addItem() {
    if (this.newItem) {
      this.items.push(this.newItem);
      this.newItem = '';
    }
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
  }

  submit() {
    this.close.emit();
    this.router.navigate(['/room/1']);
  }

  closeDialog() {
    this.close.emit();
  }
}
