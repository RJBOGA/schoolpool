import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule, MatIconAnchor, MatIconButton } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

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

  onSubmit() {
    // TODO: Implement login logic
    console.log('Login submitted', this.emailid, this.password);
  }
}