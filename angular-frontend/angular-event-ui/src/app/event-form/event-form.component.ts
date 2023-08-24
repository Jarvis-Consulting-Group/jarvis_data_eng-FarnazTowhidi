import { Component } from '@angular/core';
import { EventService } from '../event.service';
import { IEvent } from '../event';
import { Router } from '@angular/router';


@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent {

  name: string= "event name"
  host: string="host"
  date: string= "E Date"
  location: string = "E location"

  constructor (
    private eventService: EventService,
    private router:Router
  ){}

  public addEvent () {
      let event: IEvent = {
        name:this.name,
        host:this.host,
        date:this.date,
        location:this.location
      }
    this.eventService.addEvent(event)
    this.eventService.listEvent()
    console.log (this.eventService.event)
    this.router.navigateByUrl('/eventList');
  }
}
