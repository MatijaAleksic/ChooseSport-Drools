import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private _api_url = 'http://localhost:8080';
  private _user_url = this._api_url + '/user';
  private _client_url = this._api_url + '/client';

  private _login_url = this._user_url + '/login';
  private _register_admin_url = this._user_url + '/register-admin';
  private _register_client_url = this._user_url + '/register-client';

  private _bmi_url = this._client_url + '/bmi';
  private _krvni_pritisak_url = this._client_url + '/krvni_pritisak';
  private _sport_query_url = this._client_url + '/sport_query';
  private _heart_beat_url = this._client_url + '/heart_beat';


  get user_url(): string {
    return this._user_url;
  }
  get login_url(): string {
    return this._login_url;
  }
  get register_admin_url(): string {
    return this._register_admin_url;
  }
  get register_client_url(): string {
    return this._register_client_url;
  }
  get bmi_url(): string {
    return this._bmi_url;
  }
  get krvni_pritisak_url(): string {
    return this._krvni_pritisak_url;
  }
  get sport_query_url(): string {
    return this._sport_query_url;
  }
  get heart_beat_url(): string{
    return this._heart_beat_url;
  }

}
