import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AirportListComponent } from './airport-list/airport-list.component';

const routes: Routes = [
  { path: 'airports', component: AirportListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }