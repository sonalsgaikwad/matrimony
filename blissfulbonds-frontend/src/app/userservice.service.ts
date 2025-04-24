import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './model/user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private usersUrl = '/api';

  constructor(private httpClient: HttpClient,private router: Router) {
     // Base API endpoint 
    }


  public getUserById(id: number) {
    return this.httpClient.get<User[]>(`${this.usersUrl}/user/${id}`);
  }

  public authenticate(user: Partial<User>) {
    return this.httpClient.post<User>(`${this.usersUrl}/auth/login`, user);
  }

  public authLogout() {
    return this.httpClient.post<User>(`${this.usersUrl}/auth/logout`, {});
  }

  public saveUser(user: Partial<User>) {
    return this.httpClient.post<User>(`${this.usersUrl}/user`, user);
  }

  public updateUser(user: User) {
    return this.httpClient.put<User>(`${this.usersUrl}/user`, user);
  }
}
