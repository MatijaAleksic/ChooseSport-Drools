import { Component, OnInit } from '@angular/core';
import { Notification } from '../model/notifications';
import { interval } from 'rxjs';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  showNotification: boolean; 

  notifications: Notification[] = [];

  constructor() { }

  ngOnInit() {

    interval(5000).subscribe(() => {
      console.log("Notifikacija salje zahtev!");
    });


    let not1 = new Notification(new Date, "In the example above, the text size in em is the same as the previous example in pixels. However, with the em size, it is possible to adjust the text size in all browsers.Unfortunately, there is still a problem with older versions of Internet Explorer. The text becomes larger than it should when made larger, and smaller than it should when made smaller");
    let not2 = new Notification(new Date, "text2");
    let not3 = new Notification(new Date, "text3");
    let not4 = new Notification(new Date, "text4");
    let not5 = new Notification(new Date, "text5");
    let not6 = new Notification(new Date, "text6");
    let not7 = new Notification(new Date, "text7");
    let not8 = new Notification(new Date, "text8");
    let not9 = new Notification(new Date, "text9");

    this.notifications.push(not1);
    this.notifications.push(not2);
    this.notifications.push(not3);
    this.notifications.push(not4);
    this.notifications.push(not5);
    this.notifications.push(not6);
    this.notifications.push(not7);
    this.notifications.push(not8);
    this.notifications.push(not9);

  }

  openNotification(state: boolean) {
    this.showNotification = state;
  }

  clickOutside(){
    console.log("a");
    this.showNotification = false;
  }

}
