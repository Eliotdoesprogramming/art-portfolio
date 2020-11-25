import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AllCommissionViewComponent } from './all-commission-view/all-commission-view.component';
import { AllLicenseViewerComponent } from './all-license-viewer/all-license-viewer.component';
import { CommissionComponent } from './commission/commission.component';
import { ContactInfoComponent } from './contact-info/contact-info.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DisplayAllImagesComponent } from './display-all-images/display-all-images.component';
import { ImageByIdComponent } from './image-by-id/image-by-id.component';
import { LicenseRequestComponent } from './license-request/license-request.component';
import { PendingCommissionViewComponent } from './pending-commission-view/pending-commission-view.component';
import { PendinglrqViewerComponent } from './pendinglrq-viewer/pendinglrq-viewer.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard',pathMatch:'full'},
  { path:'dashboard', component:DashboardComponent},
  { path:'images',component:DisplayAllImagesComponent},
  { path: 'license/:id',component:LicenseRequestComponent},
  { path: 'contact',component:ContactInfoComponent},
  {path: 'commission',component:CommissionComponent},
  {path:'search', component:SearchComponent},
  {path:'images/:id',component:ImageByIdComponent},
  {path:'admin', component:AdminDashboardComponent},
  {path:'admin/all-lrq',component:AllLicenseViewerComponent},
  {path:'admin/pending-lrq',component:PendinglrqViewerComponent},
  {path:'admin/all-comm', component:AllCommissionViewComponent},
  {path: 'admin/pending-comm',component:PendingCommissionViewComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
