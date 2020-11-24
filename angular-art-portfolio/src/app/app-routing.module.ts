import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommissionComponent } from './commission/commission.component';
import { ContactInfoComponent } from './contact-info/contact-info.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DisplayAllImagesComponent } from './display-all-images/display-all-images.component';
import { ImageByIdComponent } from './image-by-id/image-by-id.component';
import { ImageDisplayComponent } from './image-display/image-display.component';
import { LicenseRequestComponent } from './license-request/license-request.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard',pathMatch:'full'},
  { path:'dashboard', component:DashboardComponent},
  { path:'images',component:DisplayAllImagesComponent},
  { path: 'license/:id',component:LicenseRequestComponent},
  { path: 'contact',component:ContactInfoComponent},
  {path: 'commission',component:CommissionComponent},
  {path:'search', component:SearchComponent},
  {path:'images/:id',component:ImageByIdComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
