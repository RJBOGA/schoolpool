import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { PostRideComponent } from './rides/post-ride/post-ride.component';
import { RequestRideComponent } from './rides/request-ride/request-ride.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'post-ride', component: PostRideComponent },
  { path: 'request-ride', component: RequestRideComponent },
];