import { Component, Input, OnInit } from '@angular/core';
import { GrantedLicense } from '../grantedLicense';

@Component({
  selector: 'app-granted-license-view',
  templateUrl: './granted-license-view.component.html',
  styleUrls: ['./granted-license-view.component.css']
})
export class GrantedLicenseViewComponent implements OnInit {
  @Input() license:GrantedLicense;
  constructor() { }

  ngOnInit(): void {
  }

}
