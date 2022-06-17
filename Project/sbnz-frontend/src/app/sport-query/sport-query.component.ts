import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { ClientService } from '../services/client.service';
import { SportQueryService } from '../services/sport-query.service';

// https://www.youtube.com/watch?v=ITPjL7L4sqU&ab_channel=Let%27sProgram
//1:23:11

@Component({
  selector: 'app-sport-query',
  templateUrl: './sport-query.component.html',
  styleUrls: ['./sport-query.component.css']
})
export class SportQueryComponent implements OnInit {

  public questionList: any = [];
  public currentQuestion: number=0;
  progress:string="0";

  public questinNumber = 1;


  private precision : number = null;
  private endurance : number = null;
  private technique : number = null;
  private speed : number = null;
  private strength : number = null;

  private sportType : number = null;
  private sportCategory : number = null;
  private sportPrice : number = null;

  private questionOffset : number = null;

  constructor(
    private sportQueryService : SportQueryService,
    private clientService: ClientService,
    private authService : AuthService,
    private router: Router,
    ) { }


  getAllQuestions(){

    this.sportQueryService.getQuestionJson()
    .subscribe(res =>{
      this.questionList = res.questions;
    })

  }

  ngOnInit() {
    this.getAllQuestions();
  }

  resetQuestions(){
    this.currentQuestion = 0;

    this.sportType = null;
    this.sportPrice = null;
    this.sportCategory = null;

    this.precision = null;
    this.endurance = null;
    this.technique = null;
    this.speed = null;
    this.strength = null;

    this.questinNumber = 1;

    this.calculateProgressBar();

  }

  answer(answer, option){
    if(answer.questionType === "sportType"){
      if(option.value === 0){this.questionOffset = 1;}  
      if(option.value === 1){this.questionOffset = 2;}  
      if(option.value === 2){this.questionOffset = 3;}  
      this.sportType = option.value;
      this.currentQuestion++;
      this.questinNumber++;
      
    }

    if(answer.questionType === "sportPrice"){
        this.sportPrice = option.value;
        this.currentQuestion = this.currentQuestion + this.questionOffset;
        this.questinNumber++;
    }

    if(answer.questionType === "sportCategory"){
        this.sportCategory = option.value;
        this.currentQuestion = this.currentQuestion + 4 - this.questionOffset;
        this.questinNumber++;
    }

    if(answer.questionType === "precision"){
      this.precision = option.value;
      this.currentQuestion++;
      this.questinNumber++;
    }
    if(answer.questionType === "endurance"){
      this.endurance = option.value;
      this.currentQuestion++;
      this.questinNumber++;
    }
    if(answer.questionType === "technique"){
      this.technique = option.value;
      this.questinNumber++;
      this.currentQuestion++;
    }
    if(answer.questionType === "speed"){
      this.speed = option.value;
      this.currentQuestion++;
      this.questinNumber++;
    }
    if(answer.questionType === "strength"){
      this.strength = option.value;
      this.currentQuestion++;
    }

    this.calculateProgressBar();
  }

  calculateProgressBar(){
    let counter = 0;

    if(this.sportType != null){
      counter ++;
    }
    if(this.sportCategory != null){
      counter ++;
    }
    if(this.sportPrice != null){
      counter ++;
    }
    if(this.precision != null){
      counter ++;
    }
    if(this.strength != null){
      counter ++;
    }
    if(this.endurance != null){
      counter ++;
    }
    if(this.technique != null){
      counter ++;
    }
    if(this.speed != null){
      counter ++;
    }

    let result = 0;

    result = (100 * counter)/8;

    this.progress = result.toString();
  }

  finishQuiz(){
    this.clientService.query_sport(this.authService.getCurrentUserId(), Number(this.precision), Number(this.endurance), Number(this.technique),
      Number(this.speed), Number(this.strength), this.sportType, this.sportPrice, this.sportCategory)
        .subscribe(data => {
          this.router.navigate(['/']);
        },
          error => {
            console.log(error);
          });

  }


}
