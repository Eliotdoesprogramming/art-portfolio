import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminService } from '../admin.service';
import { LicenseRequest } from '../licenseRequest';

@Component({
  selector: 'app-all-license-viewer',
  templateUrl: './all-license-viewer.component.html',
  styleUrls: ['./all-license-viewer.component.css']
})
export class AllLicenseViewerComponent implements OnInit {
  licenses: LicenseRequest[];
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.getLicenses();
  }
  getLicenses():void{
    this.adminService.getAllLicenseRequests().subscribe(licenses => this.licenses=licenses);
  }

}
