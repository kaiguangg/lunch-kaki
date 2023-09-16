import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  showDialog = false;
  constructor(private router: Router) { }

  // 
  onSubmit(form: NgForm) {
    console.log(form.value);  // { pin: '123456' }
  }

  showModal() {
    this.showDialog = true;
  }

  closeModal() {
    // Logic to close modal
    this.showDialog = false;
  }

}
