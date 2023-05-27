import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';


@Component({
  selector: 'app-trader-list',
  templateUrl: './trader-list.component.html',
  styleUrls: ['./trader-list.component.css'],
})


export class TraderListComponent {
  constructor(
    private router: Router,
    public dataService: DataService) 
  {}
  
  dataSource: any ;
  columnsToDisplay = ['firstName', 'lastName', 'dob', 'country', 'action'];


  ngOnInit() {
    this.dataSource = this.dataService.listTrade();
    console.log (this.dataService.listTrade());
  }

  NavigateForm() {
    this.router.navigateByUrl('/addTrade');
  }    
  
  deleteTrader(key:string) {
    this.dataService.deleteTrader(key);
    //this.dataService.listTrade();
    this.router.navigateByUrl('/dashboard');
  }

}

