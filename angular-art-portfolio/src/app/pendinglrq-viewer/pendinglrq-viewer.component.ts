import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { LicenseRequest } from '../licenseRequest';

@Component({
  selector: 'app-pendinglrq-viewer',
  templateUrl: './pendinglrq-viewer.component.html',
  styleUrls: ['./pendinglrq-viewer.component.css']
})
export class PendinglrqViewerComponent implements OnInit {
  pendinglrq:LicenseRequest[];
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.getPending();
  }
  getPending(): void{
    this.adminService.getPendingLicenseRequests().subscribe(lrq => this.pendinglrq=lrq);
  }

}
