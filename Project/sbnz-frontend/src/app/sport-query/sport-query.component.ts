import { Component, OnInit } from '@angular/core';
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
  progress:string="25";

  constructor(private sportQueryService : SportQueryService) { }


  getAllQuestions(){

    this.sportQueryService.getQuestionJson()
    .subscribe(res =>{
      this.questionList = res.questions;
    })

  }

  ngOnInit() {
    this.getAllQuestions();
  }

  nextQuestion(){
    if(this.currentQuestion < this.questionList.length-1){
      this.currentQuestion++;
    }
  }

  previousQuestion(){
    if(this.currentQuestion > 0){
      this.currentQuestion--;
    }
  }

  resetQuestions(){
    this.currentQuestion = 0;
  }

  answer(question, answer){
    console.log(question);
    console.log(answer);
  }

}
