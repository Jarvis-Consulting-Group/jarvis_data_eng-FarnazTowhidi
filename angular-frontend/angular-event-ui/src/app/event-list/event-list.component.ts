import { Component } from '@angular/core';
import { EventService } from '../event.service';

import { IEvent } from '../event';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  events: IEvent[] = [];
  dataSource:any;
  displayedColumns = ['name','host','date','location']

  constructor (
    private eventService: EventService
  ){}

  ngOnInit () {
    this.dataSource = this.eventService.listEvent()
  }
}
