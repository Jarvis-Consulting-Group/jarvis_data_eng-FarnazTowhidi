import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { TraderFormComponent } from './components/trader-form/trader-form.component';
import { QuotesListComponent } from './components/quotes-list/quotes-list.component';
import { TraderAccountComponent } from './components/trader-account/trader-account.component';
import { DepsitComponent } from './components/depsit/depsit.component';

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
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
