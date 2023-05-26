import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  people=[
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
  constructor() { }

  deleteTrader(keyPerson:string){  
    this.people.forEach((person,index)=> {
      if (person.key==keyPerson) {
        this.people.splice(index,1)}
    });
  }

  listTrade() {
    return (this.people);

  }
}
