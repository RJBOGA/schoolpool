import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, NgIf],
  templateUrl: `./register.component.html`,
  styleUrl: `./register.component.css`
})
export class RegisterComponent {
  user: any = {
    fname: '',
    lname: '',
    phone: '',
    emailid: '',
    password: '',
    isRider: false,
    riderProfile: {
      address: '',
      carModel: '',
      driversLicenseNumber: ''
    }
  };

  constructor(private authService: AuthService, private router: Router) { }

  onSubmit() {
    this.authService.register(this.user).subscribe(
      (response) => {
        if (response.success) {
          console.log('Registration successful', response.data);
          this.router.navigate(['/']);
        } else {
          console.error('Registration failed', response.message);
        }
      },
      (error) => {
        console.error('Registration error', error);
      }
    );
  }
}