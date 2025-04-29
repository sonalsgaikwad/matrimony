import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {FormControl, Validators, FormsModule, ReactiveFormsModule, FormGroup, FormBuilder} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
//import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
//import { AuthService } from '../auth-service.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,MatToolbarModule,RouterModule,MatIconModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  //constructor( private authService: AuthService, private userservice:UserserviceService,private router:Router){} 

   loginForm!:FormGroup;
   hidePassword=true;

   constructor(private fb:FormBuilder){
    this.loginForm=this.fb.group({
      email:[null,[Validators.required,Validators.email]],
      password:[null,[Validators.required]],
    })
   }

  togglePasswordVisibilty(){
    this.hidePassword=!this.hidePassword;
  }

  onSubmit() {
    console.log("this.loginForm.value",this.loginForm.value);
}

  errorMessage(){

}
}
