import { Routes} from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { AuthguardService } from './authguard.service';
import { LogoutComponent } from './logout/logout.component';
import { ProfileComponent } from './profile/profile.component';
import { LayoutComponent } from './layout/layout.component';


export const routes: Routes = [
    { path: '',   redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'logout', component: LogoutComponent},
    { path: 'layout', component: LayoutComponent},

    { path: 'dashboard', component: DashboardComponent, canActivate: [AuthguardService] },

];
