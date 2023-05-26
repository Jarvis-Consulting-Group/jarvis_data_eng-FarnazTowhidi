import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TraderFormComponent } from './trader-form/trader-form.component';

const routes: Routes = [
  {path:'dashboard', component:DashboardComponent},
  {path:'addTrade', component:TraderFormComponent},
  {path:'', component:DashboardComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
