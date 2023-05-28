import { Component } from '@angular/core';
import { ITrader } from '../trader';
import { Router } from '@angular/router';
import { TraderListComponent } from '../trader-list/trader-list.component';
import { TraderService } from '../trader.service';


@Component({
  selector: 'app-trader-form',
  templateUrl: './trader-form.component.html',
  styleUrls: ['./trader-form.component.css']
})
export class TraderFormComponent {

  constructor(

    private traderList:TraderListComponent,
    private router:Router,
    private traderSerivce: TraderService
    
    ){}
  
    key:string="5"
    firstName:string=""
    lastName:string=""
    dob:string=""
    country:string=""
    email:string="farnaz@"
    amount:number=0
    action:string=""

  AddTrader() {
    let newTrade:ITrader ={
      key:this.key,
      firstName:this.firstName,
      lastName:this.lastName,
      dob:this.dob,
      country:this.country,
      email:this.email,
      amount:this.amount  ,
      actions: this.action ,
    }
    this.traderSerivce.addTrade(newTrade);
    this.router.navigateByUrl('/dashboard');
  }
}
