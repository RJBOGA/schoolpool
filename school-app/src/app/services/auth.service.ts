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
    // TODO: Implement login API call when available
    return new Observable(observer => {
      const mockUser: User = { id: '1', name: 'John Doe', email, role: 'rider' };
      this.currentUserSubject.next(mockUser);
      observer.next({ success: true, data: mockUser });
      observer.complete();
    });
  }

  logout(): void {
    this.currentUserSubject.next(null);
  }
}