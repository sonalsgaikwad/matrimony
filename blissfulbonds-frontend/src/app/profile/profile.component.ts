import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {FormControl, Validators, FormsModule, ReactiveFormsModule, FormGroup, FormBuilder} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AuthService } from '../auth-service.service';

@Component({
  selector: 'app-profile',
  imports: [FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,MatToolbarModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  constructor( private authService: AuthService, private userservice:UserserviceService,private router:Router){} 
  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]);

    
  profileForm = new FormGroup({
    username: this.username,
    password: this.password
  });

  onSubmit() {
    const userCredential = this.profileForm.value;

   this.userservice.authenticate(userCredential).subscribe({
    next:(userData)=>{
      console.log('user data ',userData);
      this.authService.login();
      this.router.navigate(['/dashboard']);
    },
    error: (error) => {
      console.error('Error fetching user:', error);
      // Optionally show error to user
    }
   });
}
}
