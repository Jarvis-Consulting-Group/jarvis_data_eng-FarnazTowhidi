import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { IEvent } from './event';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  event: IEvent[]=[
    {
      name: "event1",
      host: "host1",
      date: "date1",
      location: "location1"
    },
    {
      name: "event2",
      host: "host2",
      date: "date2",
      location: "location2"
    }];

  constructor( private http:HttpClient) { }

  listEvent() {
     const res = this.http.get('http://localhost:3000/api/get')   
     return res;
  }

  deleteEvent(name:string) {
    this.event.filter (event=>event.name!=name)
  }

  addEvent(event:IEvent):Observable<any> {
    //this.event=[...this.event, event] 
    const res = this.http.post ('http://localhost:3000/api/post', JSON.stringify(event))
    const res2 = this.http.post ('http://localhost:3000/api/post', JSON.stringify(event)).subscribe(
    )
    return res;
  }
}
