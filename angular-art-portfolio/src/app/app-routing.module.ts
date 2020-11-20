import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DisplayAllImagesComponent } from './display-all-images/display-all-images.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard',pathMatch:'full'},
  { path:'dashboard', component:DashboardComponent},
  { path:'images',component:DisplayAllImagesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
