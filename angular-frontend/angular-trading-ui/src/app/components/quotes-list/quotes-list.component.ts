import { Component } from '@angular/core';
import { QuoteService } from '../../Services/quote.service';

@Component({
  selector: 'app-quotes-list',
  templateUrl: './quotes-list.component.html',
  styleUrls: ['./quotes-list.component.css']
})
export class QuotesListComponent {
  dataSource :any;
  displayedColumns = ['ticker','lastPrice','bidPrice','bidSize','askPrice','askSize']

  constructor(
    public quoteService:QuoteService
  ) {}
  
  ngOnInit() {
    this.dataSource = this.quoteService.listQuote();
    console.log (this.dataSource)
  }
  
}
