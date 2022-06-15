import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService,
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

}
