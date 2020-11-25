import { Component, Input, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { LicenseRequest } from '../licenseRequest';

@Component({
  selector: 'app-license-display',
  templateUrl: './license-display.component.html',
  styleUrls: ['./license-display.component.css']
})
export class LicenseDisplayComponent implements OnInit {
  @Input() license:LicenseRequest;
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
  }
  grantLicense():void{
    if(this.adminService.grantLicense(this.license.id).subscribe())
      alert('license granted.');
  }

}
