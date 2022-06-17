import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BmiComponent } from './bmi/bmi.component';

import { HomeComponent } from './home/home.component';
import { KrvniPritisakComponent } from './krvni-pritisak/krvni-pritisak.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SportQueryComponent } from './sport-query/sport-query.component';

// todo: dodati Auth Guards na putanje
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'bmi',
    component: BmiComponent,
  },
  {
    path: 'krvni-pritisak',
    component: KrvniPritisakComponent,
  },
  {
    path: 'sport-query',
    component: SportQueryComponent,
  },
  // {
  //   path: 'user-table',
  //   component: UserTableComponent,
  // },
  // {
  //   path: 'add-user',
  //   component: AddUserComponent,
  // },
  // {
  //   path: 'device-table',
  //   component: DeviceTableComponent,
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
