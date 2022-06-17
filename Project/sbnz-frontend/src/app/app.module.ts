import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

import {AngularMaterialModule} from './angular-material/angular-material.module';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { ApiService } from './services/api.service';
import { ConfigService } from './services/config.service';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './register/register.component';
import { BmiComponent } from './bmi/bmi.component';
import { KrvniPritisakComponent } from './krvni-pritisak/krvni-pritisak.component';
import { SportQueryComponent } from './sport-query/sport-query.component';
import { NotificationsComponent } from './notifications/notifications.component';


@NgModule({
  declarations: [
    AppComponent,

    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    BmiComponent,
    KrvniPritisakComponent,
    SportQueryComponent,
    NotificationsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    NoopAnimationsModule,
    HttpClientModule,    
  ],
  providers: [
    AuthService,
    ApiService,
    ConfigService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
