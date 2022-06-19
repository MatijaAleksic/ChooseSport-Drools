import { Component, OnInit } from '@angular/core';
import { Notification } from '../model/notifications';
import { interval } from 'rxjs';
import { ClientService } from '../services/client.service';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  showNotification: boolean; 

  notifications: Notification[] = [];

  all_notifications: number = 0;
  read_notifications: number = 0;

  constructor(
    private clientService : ClientService,
    private authService : AuthService,
  ) { }

  ngOnInit() {
    if(this.authService.userInfo != null){
      interval(3000).subscribe(() => {
        this.clientService.get_notifications(this.authService.getCurrentUserId())
          .subscribe(data => {
            this.notifications = data;
            this.all_notifications = this.notifications.length;
            // this.router.navigate(['/']);
          },
            error => {
              console.log(error);
            });
      });
    }
  }

  openNotification(state: boolean) {
    this.showNotification = state;
    this.read_notifications = this.all_notifications;
  }


}
