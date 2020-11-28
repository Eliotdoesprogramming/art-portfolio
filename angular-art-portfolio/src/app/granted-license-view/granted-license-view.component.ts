import { Component, Input, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { GrantedLicense } from '../grantedLicense';

@Component({
  selector: 'app-granted-license-view',
  templateUrl: './granted-license-view.component.html',
  styleUrls: ['./granted-license-view.component.css']
})
export class GrantedLicenseViewComponent implements OnInit {
  @Input() license:GrantedLicense;
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
  }
  revokeLicense():void{
    
    this.adminService.revokeLicense(this.license.reqId).subscribe();
    this.license=undefined;
  }
}
