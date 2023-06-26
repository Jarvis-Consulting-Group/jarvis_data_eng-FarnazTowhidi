import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list.component';
import { EventFormComponent } from './event-form/event-form.component';


const routes: Routes = [
  { path: 'eventList', component:  EventListComponent},
  { path: 'eventAdd', component:  EventFormComponent},
  { path: '', component: EventListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
