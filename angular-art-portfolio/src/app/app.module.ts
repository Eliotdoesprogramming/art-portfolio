import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { ToolbarComponent } from './toolbar/toolbar.component';
import {HttpClientModule} from '@angular/common/http';
// import { InMemImagesService } from './in-mem-images.service';
import { ImageDisplayComponent } from './image-display/image-display.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DisplayAllImagesComponent } from './display-all-images/display-all-images.component';
import {MatCardModule} from '@angular/material/card';
import {MatSidenavModule} from '@angular/material/sidenav';
import { LicenseRequestComponent } from './license-request/license-request.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import { ContactInfoComponent } from './contact-info/contact-info.component';
import { CommissionComponent } from './commission/commission.component';
import { SearchComponent } from './search/search.component';


 




@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    ImageDisplayComponent,
    DashboardComponent,
    DisplayAllImagesComponent,
    LicenseRequestComponent,
    ContactInfoComponent,
    CommissionComponent,
    SearchComponent,
  
  

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    HttpClientModule,
    //HttpClientInMemoryWebApiModule.forRoot(
      // InMemImagesService, { dataEncapsulation: false },)
    MatSidenavModule,
    MatFormFieldModule,
    MatSelectModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
