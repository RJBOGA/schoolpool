import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/users';
  private authUrl = 'http://localhost:8080/api/auth/login'
  private currentUserSubject: BehaviorSubject<User | null>;
  public currentUser: Observable<User | null>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User | null>(null);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user).pipe(
      tap((response: any) => {
        if (response.success) {
          this.currentUserSubject.next(response.data);
        }
      })
    );
  }

  login(email: string, password: string): Observable<any> {
    const loginData = { mailID: email, password: password };
    return this.http.post(this.authUrl, loginData).pipe(
      tap((response: any) => {
        if (response.success) {
          this.currentUserSubject.next(response.data);
        }
      })
    );
  }

  logout(): void {
    this.currentUserSubject.next(null);
  }
}