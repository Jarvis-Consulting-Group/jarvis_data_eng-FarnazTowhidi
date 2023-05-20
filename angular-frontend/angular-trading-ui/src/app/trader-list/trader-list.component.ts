import { Component } from '@angular/core';


@Component({
  selector: 'app-trader-list',
  templateUrl: './trader-list.component.html',
  styleUrls: ['./trader-list.component.css']
})


export class TraderListComponent {
  message = "To Do Title";
  people=[
    {
    "key": "1",
    "id": 1,
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
      "id": 2,
      "firstName": "Hellen",
      "lastName": "Miller",
      "dob": "1990-01-01",
      "country": "Austria",
      "email": "hellen@test.com",
      "actions": "<button (click)='deleteTrader'>Delete Trader</button>",
      "amount": 0
  },
  {
      "key": "3",
      "id": 3,
      "firstName": "Jack",
      "lastName": "Reed",
      "dob": "1990-01-01",
      "country": "United Kingdom",
      "email": "jack@test.com",
      "actions": "<button (click)='deleteTrader'>Delete Trader</button>",
      "amount": 0
  }
  ];
}
