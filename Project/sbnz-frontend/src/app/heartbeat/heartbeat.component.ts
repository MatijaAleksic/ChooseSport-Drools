import { Component, OnInit } from '@angular/core';

import { interval } from 'rxjs';
import { ClientService } from '../services/client.service';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-heartbeat',
  templateUrl: './heartbeat.component.html',
  styleUrls: ['./heartbeat.component.css']
})
export class HeartbeatComponent implements OnInit {

  private startDate : Date;
  private beatPerMinute : number = 80;
  private heartBeatStatus : number = 0;

  private interval : any;
  private index : number = 0;
  private userId : number;

  private timer : any;
  private seconds : number;

  constructor(
    private clientService : ClientService,
    private authService : AuthService,
    private router: Router,

  ) { }

  ngOnInit() {
    var date_with_zone = new Date();
    
    var userTimezoneOffset = date_with_zone.getTimezoneOffset() * 60000;
    this.startDate = new Date(date_with_zone.getTime() - userTimezoneOffset);

    this.seconds = 0;
    this.timer = interval(2000).subscribe(() => {this.seconds += 1;});

    if(this.heartBeatStatus != 2)
      this.interval = interval(2000).subscribe(() => {
        this.beatPerMinute = this.beatPerMinute + this.index;
        if(this.beatPerMinute < 70){this.beatPerMinute = 70;}
        if(this.beatPerMinute > 240){this.beatPerMinute = 240;}

        // send_heartbeat(currentUserId, heartbeat, startTime, status){

        this.clientService.send_heartbeat(this.authService.getCurrentUserId(), this.beatPerMinute, this.startDate, this.heartBeatStatus)
        .subscribe(data => {
          // this.router.navigate(['/']);
        },
          error => {
            console.log(error);
          });


        if(this.heartBeatStatus == 0){
          this.heartBeatStatus = 1;
        }

        if(this.heartBeatStatus == 2){
          this.interval.unsubscribe();
          this.timer.unsubscribe();
          this.router.navigate(['/']);
        }

    });
  }



  stop(){
    this.heartBeatStatus = 2;
  }

  increase(){
    this.index += 1;
  }

  decrease(){
    this.index -= 1;
  }

}
