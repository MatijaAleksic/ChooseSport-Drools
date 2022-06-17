import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
import { map } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { MatTabBody } from '@angular/material';


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService,
    private authService: AuthService
  ) { }


  normalHeader = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  });

  caluculate_bmi(bmi, currentUserId) {

    const body = {
      'user_id' : currentUserId,
      'tezina': bmi.tezina,
      'visina': bmi.visina,
      'godine' : bmi.godine
    };

    return this.apiService.post(this.config.bmi_url, JSON.stringify(body), this.normalHeader)
      .pipe(map((res) => {
        console.log('Bmi claculated');
        console.log(res);
      }));
  }


  caluculate_krvni_pritisak(kp, currentUserId) {

    const body = {
      'user_id' : currentUserId,
      'gornji_pritisak': kp.gornji,
      'donji_pritisak': kp.donji,
    };

    return this.apiService.post(this.config.krvni_pritisak_url, JSON.stringify(body), this.normalHeader)
      .pipe(map((res) => {
        console.log('Krvni pritisak claculated');
        console.log(res);
      }));
  }

  query_sport(userId, preciznost, izdrzljivost, tehnika, brzina, snaga, tipSporta, cena, podkategorija){
    let body = null;

    if(tipSporta===0){
      body = {
        'userId' : userId,
        'preciznost': preciznost,
        'izdrzljivost' : izdrzljivost,
        'tehnika' : tehnika,
        'brzina' :brzina,
        'snaga' : snaga,
  
        'tipSporta' : tipSporta,
        'indPodkategorija' : podkategorija,
        'cena' : cena
      };
    }
    if(tipSporta===1){
      body = {
        'userId' : userId,
        'preciznost': preciznost,
        'izdrzljivost' : izdrzljivost,
        'tehnika' : tehnika,
        'brzina' :brzina,
        'snaga' : snaga,
  
        'tipSporta' : tipSporta,
        'timPodkategorija' : podkategorija,
        'cena' : cena
      };}
    if(tipSporta===2){
      body = {
        'userId' : userId,
        'preciznost': preciznost,
        'izdrzljivost' : izdrzljivost,
        'tehnika' : tehnika,
        'brzina' :brzina,
        'snaga' : snaga,
  
        'tipSporta' : tipSporta,
        'eksPodkategorija' : podkategorija,
        'cena' : cena
      };} 

    console.log(body);

    return this.apiService.post(this.config.sport_query_url, JSON.stringify(body), this.normalHeader)
      .pipe(map((res) => {
        console.log('Sport query claculated');
        console.log(res);
      }));

  }

  findUser(){
    let body = {
      'id' : this.authService.getCurrentUserId(),
      'role' : this.authService.getCurrentUserRole()
    };

    return this.apiService.post(this.config.user_url, JSON.stringify(body), this.normalHeader);
  }

}
