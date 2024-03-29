import { Injectable } from '@angular/core';
import { IQuote } from '../models/quote';


@Injectable({
  providedIn: 'root'
})
export class QuoteService {
  QuoteList:IQuote[]=[
    {
        "ticker": "FB",
        "lastPrice": 319.48,
        "bidPrice": 0,
        "bidSize": 13,
        "askPrice": 13,
        "askSize": 400
    },
    {
        "ticker": "AAPL",
        "lastPrice": 500.23,
        "bidPrice": 0,
        "bidSize": 18,
        "askPrice": 18,
        "askSize": 100
    },
    {
        "ticker": "MSFT",
        "lastPrice": 100.53,
        "bidPrice": 0,
        "bidSize": 25,
        "askPrice": 25,
        "askSize": 200
    },
    {
        "ticker": "GOOGL",
        "lastPrice": 500.99,
        "bidPrice": 0,
        "bidSize": 30,
        "askPrice": 10,
        "askSize": 400
    },
    {
        "ticker": "AMZN",
        "lastPrice": 85.50,
        "bidPrice": 0,
        "bidSize": 16,
        "askPrice": 16,
        "askSize": 150
    }
]

  constructor() {  
  }
  
  listQuote() {
    return this.QuoteList
  }

  deleteQuete(key:string) {}
  editQuete() {}
}
