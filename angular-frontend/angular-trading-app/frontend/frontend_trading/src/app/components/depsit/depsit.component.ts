import { Component } from '@angular/core';
import { TraderService } from '../../services/trader.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-depsit',
  templateUrl: './depsit.component.html',
  styleUrls: ['./depsit.component.css']
})
export class DepsitComponent  {
  deposit:number=0;
  id: string=""; 
  id2: string=""

  
  constructor (
    private route: ActivatedRoute,
    private traderService:TraderService
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id']
    console.log ("id")
    console.log (this.id)

    this.id2 = this.traderService.getQueryParams()
    console.log ("id2")
    console.log (this.id2)
  }

  addDeposite () {}

}
