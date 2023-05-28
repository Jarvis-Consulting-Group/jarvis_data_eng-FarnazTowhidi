import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TraderService } from '../trader.service';



@Component({
  selector: 'app-trader-list',
  templateUrl: './trader-list.component.html',
  styleUrls: ['./trader-list.component.css'],
})


export class TraderListComponent {
  constructor(
    private router: Router,
    public traderSerivce: TraderService) 
  {}
  
  dataSource: any ;
  columnsToDisplay = ['firstName', 'lastName', 'dob', 'country', 'action'];


  ngOnInit() {
    this.dataSource = this.traderSerivce.listTrade();
    console.log (this.traderSerivce.listTrade());
  }

  NavigateForm() {
    this.router.navigateByUrl('/addTrade');
  }    
  
  loadTrader () {
    this.dataSource = this.traderSerivce.listTrade();
    console.log (this.traderSerivce.listTrade());
  }

  deleteTrader(key:string) {
    this.traderSerivce.deleteTrader(key);
    this.loadTrader()
  }

}

