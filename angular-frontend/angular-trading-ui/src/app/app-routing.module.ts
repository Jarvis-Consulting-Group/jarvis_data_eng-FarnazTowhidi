import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TraderFormComponent } from './trader-form/trader-form.component';
import { QuotesListComponent } from './quotes-list/quotes-list.component';
import { TraderAccountComponent } from './trader-account/trader-account.component';
import { DepsitComponent } from './depsit/depsit.component';


const routes: Routes = [
  {path:'dashboard', component:DashboardComponent},
  {path:'quotes', component:QuotesListComponent},
  {path:'traderAccount/:id', component:TraderAccountComponent},
  {path:'deposit/:id', component:DepsitComponent},
  {path:'withdraw', component:TraderFormComponent},
  {path:'addTrade', component:TraderFormComponent},
  {path:'', component:DashboardComponent},
  {path: '**', component:DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
