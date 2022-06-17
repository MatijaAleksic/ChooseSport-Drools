import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor( 
    private authService: AuthService,
    ) { }

  ngOnInit() {
    
  }

  hasSignedIn() {
    return !!this.authService.userInfo;
  }

  logout() {
    this.authService.logout();
  }

  isUserAdmin(){
    if(this.authService.userInfo != null){
      if(this.authService.userInfo.role == "admin")
      {
        return true;
      }
    }
  }

}
