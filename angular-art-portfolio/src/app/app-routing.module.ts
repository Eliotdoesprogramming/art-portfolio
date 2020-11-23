import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DisplayAllImagesComponent } from './display-all-images/display-all-images.component';
import { LicenseRequestComponent } from './license-request/license-request.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard',pathMatch:'full'},
  { path:'dashboard', component:DashboardComponent},
  { path:'images',component:DisplayAllImagesComponent},
  { path: 'license/:id',component:LicenseRequestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
