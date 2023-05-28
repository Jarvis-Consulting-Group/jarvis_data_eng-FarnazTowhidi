import { Injectable } from '@angular/core';
import { ITrader } from './trader'
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TraderService {

  traderId: string=""
  trader=[
    {
    "key": "1",
    "firstName": "Mike",
    "lastName": "Spencer",
    "dob": "1990-01-01",
    "country": "Canada",
    "email": "mike@test.com",
    "amount": 0,
    "actions": "<button (click)='deleteTrader'>Delete Trader</button>"
  },
  {
      "key": "2",
      "firstName": "Hellen",
      "lastName": "Miller",
      "dob": "1990-01-01",
      "country": "Austria",
      "email": "hellen@test.com",
      "amount": 0,
      "actions": "<button (click)='deleteTrader'>Delete Trader</button>"
  },
  {
      "key": "3",
      "firstName": "Jack",
      "lastName": "Reed",
      "dob": "1990-01-01",
      "country": "United Kingdom",
      "email": "jack@test.com",
      "amount": 0,
      "actions": "<button (click)='deleteTrader'>Delete Trader</button>"
  }
  ];
  constructor(private route:ActivatedRoute) { }
  
  deleteTrader(keyPerson:string){  
    const deleteIndex : number = this.trader.findIndex(trader=>trader.key==keyPerson)
    if(deleteIndex > -1){ 
      this.trader = this.trader.filter(trader => trader.key !== keyPerson); 
    }
  }

  listTrade() {
    return (this.trader);
  }

  addTrade(trade:ITrader) {
    this.trader= [...this.trader, trade];
  }

  getTraderById (key:string) {
    return this.trader.find (trader=>trader.key=key)
  }

  getQueryParams () {
    this.traderId = this.route.snapshot.params['id']
    console.log ("Trader Service ID")
    console.log (this.traderId)
    console.log (this.route.snapshot.queryParamMap.get('id'))
    return this.traderId
  }
}
