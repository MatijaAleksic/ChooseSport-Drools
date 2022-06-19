import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public tezina : any;
  public visina : any;
  public godine : any;

  public bmiStatus : any;


  public imeSporta : any;

  public preciznost : any;
  public izdrzljivost : any;
  public tehnika : any;
  public brzina : any;
  public snaga : any;

  public vezbeSnage : any;
  public vezbeKardio : any;
  public cenaSporta : any;

  public godnjiPritisak : any;
  public donjiPritisak : any;
  public pritisakStatus : any;


  constructor(
    private clientService : ClientService,
    private authService : AuthService,
  ) { }

  ngOnInit() {

    if(this.authService.userInfo != null){
      this.clientService.findUser()
          .subscribe(data => {
            this.authService.setCurrentUser(data);

            if(data.bmi){
              this.tezina = data.bmi.tezina;
              this.visina = data.bmi.tezina;
              this.godine = data.bmi.godine;
              this.bmiStatus = data.bmi.status;
            }
            else{
              this.tezina = 0;
              this.visina = 0;
              this.godine = 0;
              this.bmiStatus = "NA";
            }


            if(data.sport)
            {
              this.imeSporta = data.sport.ime;

              this.preciznost = data.sport.preciznost;
              this.izdrzljivost = data.sport.izdrzljivostnost;
              this.tehnika = data.sport.tehnika;
              this.brzina = data.sport.brzina;
              this.snaga = data.sport.snaga;

              this.vezbeSnage = data.sport.vezbeSnage;
              this.vezbeKardio = data.sport.vezbeIzdrzljivosti;
              this.cenaSporta = data.sport.cena;
            }
            else{
              this.imeSporta = "Sport jos nije odabran";

              this.preciznost = 0;
              this.izdrzljivost = 0;
              this.tehnika = 0;
              this.brzina = 0;
              this.snaga = 0;

              this.vezbeSnage = 0;
              this.vezbeKardio = 0;
              this.cenaSporta = "NA";
            }

            if(data.pritisak){
              this.godnjiPritisak = data.pritisak.gornji_pritisak;
              this.donjiPritisak = data.pritisak.donji_pritisak;
              this.pritisakStatus = data.pritisak.status;
            }
            else{
              this.godnjiPritisak = 0;
              this.donjiPritisak = 0;
              this.pritisakStatus = "NA";
            }
          },
            error => {
              console.log(error);
            });
      }
    }

  isUserClient(){
    if(this.authService.userInfo != null){
      if(this.authService.userInfo.role == "client")
      {
        return true;
      }
    }
  }

  hasChoosenSport(){
    if(this.authService.userInfo != null){
      if(this.authService.userInfo.user.sport!=null)
      {
        return true;
      }
    }
  }

  startTraining(){
    alert("Poceo treniranje!")
  }
  
}
