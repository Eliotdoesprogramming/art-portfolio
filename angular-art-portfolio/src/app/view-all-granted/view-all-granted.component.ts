import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { GrantedLicense } from '../grantedLicense';

@Component({
  selector: 'app-view-all-granted',
  templateUrl: './view-all-granted.component.html',
  styleUrls: ['./view-all-granted.component.css']
})
export class ViewAllGrantedComponent implements OnInit {
  licenses:GrantedLicense[];
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.getGrantedLicenses();
  }
  getGrantedLicenses():void{
    this.adminService.getGrantedLicenses().subscribe(licenses => this.licenses=licenses);
  }
}
