import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { UserserviceService } from './userservice.service';
import { AuthService } from './auth-service.service';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,MatMenuModule,MatButtonModule,MatToolbarModule,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  
  constructor(private authService: AuthService, private userservice:UserserviceService,private router: Router) {}

  title = 'Blissful Bonds';
  isLoggedIn = false;

  
  ngOnInit(): void {
    this.authService.checkInitialLoginStatus(); // Initialize on app load
    this.authService.isLoggedIn$.subscribe(status => {
      this.isLoggedIn = status;
      console.log('AppComponent login status:', this.isLoggedIn);
    });
  }

  logoutUser() {
    this.userservice.authLogout().subscribe({
      next: () => {
        this.authService.logout();
        this.router.navigate(['/login']);
      },
      error: () => {
        this.authService.logout();
        this.router.navigate(['/login']);
      }
    });
  }

}
