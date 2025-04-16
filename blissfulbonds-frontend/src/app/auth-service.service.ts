import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false);

  // Observable for components to subscribe
  isLoggedIn$ = this.loggedIn.asObservable();

  // Call this on login
  login(): void {
    this.loggedIn.next(true);
    localStorage.setItem('isLoggedIn', 'true');
  }

  // Call this on logout
  logout(): void {
    this.loggedIn.next(false);
    localStorage.removeItem('isLoggedIn');
  }

  // Initialize from localStorage (optional)
  checkInitialLoginStatus(): void {
    const status = localStorage.getItem('isLoggedIn') === 'true';
    this.loggedIn.next(status);
  }
}
