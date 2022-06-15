import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../services/client.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { AuthService } from '../services/auth.service';



interface DisplayMessage {
  msgType: string;
  msgBody: string;
}

@Component({
  selector: 'app-bmi',
  templateUrl: './bmi.component.html',
  styleUrls: ['./bmi.component.css']
})
export class BmiComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  notification: DisplayMessage;

  returnUrl: string;
  private ngUnsubscribe: Subject<void> = new Subject<void>();
  
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private clientService: ClientService,
    private authService: AuthService

  ) { }

  ngOnInit() {
    this.route.params
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe((params: DisplayMessage) => {
        this.notification = params;
      });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    
    this.form = this.formBuilder.group({
      tezina: ['',Validators.compose([Validators.required, Validators.min(20), Validators.max(300)])],
      visina: ['', Validators.compose([Validators.required, Validators.min(20), Validators.max(300)])],
      godine: ['', Validators.compose([Validators.required, Validators.min(1), Validators.max(120)])],
    });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  onSubmit() {
    /**
     * Innocent until proven guilty
     */
    this.notification = undefined;
    this.submitted = true;

    this.clientService.caluculate_bmi(this.form.value, this.authService.getCurrentUserId())
        .subscribe(data => {
          console.log(data);
          this.authService.setCurrentUserBmi(data);
          this.router.navigate([this.returnUrl]);
        
        },
          error => {
            this.submitted = false;
            this.notification = { msgType: 'error', msgBody: error['error'].message };
          });

  }

}
