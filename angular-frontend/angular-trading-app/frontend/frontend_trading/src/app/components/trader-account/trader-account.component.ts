import { Component } from '@angular/core';
import { ITrader } from '../../models/trader'
import { TraderService } from '../../services/trader.service';

@Component({
  selector: 'app-trader-account',
  templateUrl: './trader-account.component.html',
  styleUrls: ['./trader-account.component.css']
})
export class TraderAccountComponent {
  trader:ITrader | undefined;  ;

  constructor(
    private traderService : TraderService
  ) {}

  ngOnInit() {
    this.trader = this.traderService.getTraderById ("2")
  }

}
