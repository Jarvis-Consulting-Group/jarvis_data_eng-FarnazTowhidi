import { Component } from '@angular/core';
import { Trade } from '../trade';
import { Router } from '@angular/router';
import { TraderListComponent } from '../trader-list/trader-list.component';
import { DataService } from '../data.service';


@Component({
  selector: 'app-trader-form',
  templateUrl: './trader-form.component.html',
  styleUrls: ['./trader-form.component.css']
})
export class TraderFormComponent {

  constructor(

    private traderList:TraderListComponent,
    private router:Router,
    private dataSerivce: DataService
    
    ){}
  
    key:string="5"
    firstName:string=""
    lastName:string=""
    dob:string=""
    country:string=""
    email:string="farnaz@"
    amount:number=0
  

  AddTrader() {
    let newTrade:Trade ={
      key:this.key,
      firstName:this.firstName,
      lastName:this.lastName,
      dob:this.dob,
      country:this.country,
      email:this.email,
      amount:this.amount
      
    }
    //this.dataSerivce.people= [...this.dataSerivce.people, newTrade];
    console.log (this.dataSerivce.people);
    this.router.navigateByUrl('/dashboard');
  }
}
