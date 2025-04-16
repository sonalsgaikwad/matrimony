import { Component } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { UserserviceService } from '../userservice.service';
import { NgIf } from '@angular/common';


@Component({
  selector: 'app-dashboard',
  imports: [MatMenuModule,MatButtonModule,MatToolbarModule,RouterModule,NgIf],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  title='Blissful Bonds';

  constructor(private userservice:UserserviceService,private router: Router) {}

}
