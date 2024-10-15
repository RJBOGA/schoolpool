import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule, MatIconAnchor, MatIconButton } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatIconModule],
  templateUrl: `./login.component.html`,
  styleUrls: ['./login.component.css'],
  
})
export class LoginComponent {
  showPassword = false;
  emailid: string = '';
  password: string = '';

  constructor(private authService: AuthService) {}  // Inject AuthService

  onSubmit() {
    if (this.emailid && this.password) {
      this.authService.login(this.emailid, this.password).subscribe({
        next: (response) => {
          if (response.success) {
            console.log('Login successful');
          }
        },
        error: (err) => {
          console.error('Login failed', err);
        }
      });
    }
  }
}