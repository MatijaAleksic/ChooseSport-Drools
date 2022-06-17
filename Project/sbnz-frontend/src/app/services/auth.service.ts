import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { _throw } from 'rxjs/observable/throw';

@Injectable()
export class AuthService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService,
    private router: Router,
  ) {
  }

  normalHeader = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  });

  private token = null;
  private access_token = null;

  public userInfo = null;

  login(user) {

    const body = {
      'email': user.email,
      'password': user.password
    };


    return this.apiService.post(this.config.login_url, JSON.stringify(body), this.normalHeader)
      .pipe(map((res) => {
        console.log('Login success');
        this.userInfo = res;
        console.log(this.userInfo);
      }));
  }

  registerClient(data) {
    const body = {
      'email': data.email,
      'password': data.password
    };

    return this.apiService.post(this.config.register_client_url, JSON.stringify(body), this.normalHeader)
      .pipe(map((res) => {
        console.log('Registration success');
      }));

  }

  logout() {
    this.userInfo = null;
  }

  getCurrentUserId(){
    return this.userInfo.user.id;
  }

  getCurrentUserRole(){
    return this.userInfo.role;
  }

  setCurrentUserBmi(bmi){
    this.userInfo.user.bmi = bmi
  }

  setCurrentUserKrvniPritisak(kp){
    this.userInfo.user.pritisak = kp
  }

  setCurrentUser(user){
    this.userInfo.user = user
  }

}
