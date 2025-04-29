import { DashboardComponent } from './dashboard/dashboard.component';

import { AuthguardService } from './authguard.service';
import { LogoutComponent } from './logout/logout.component';
import { ProfileComponent } from './profile/profile.component';
import { LayoutComponent } from './layout/layout.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/components/login/login.component';
import { SignupComponent } from './auth/components/signup/signup.component';

/*
export const routes: Routes = [
    { path: '',   redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'logout', component: LogoutComponent},
    { path: 'layout', component: LayoutComponent},

    { path: 'dashboard', component: DashboardComponent, canActivate: [AuthguardService] },

];

*/

export const routes: Routes = [
    {path: "login",component: LoginComponent},
    {path: "signup",component: SignupComponent},
    {path: "admin",loadChildren:()=> import("./modules/admin/admin.module").then(e=> e.AdminModule)},
    {path:"profile",loadChildren:()=> import("./modules/profile/profile.module").then(e=>e.ProfileModule)},


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
