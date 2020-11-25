import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { CommissionRequest } from '../commissionRequest';

@Component({
  selector: 'app-all-commission-view',
  templateUrl: './all-commission-view.component.html',
  styleUrls: ['./all-commission-view.component.css']
})
export class AllCommissionViewComponent implements OnInit {
  commissions:CommissionRequest[];
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.getAllCommissions()
  }
  getAllCommissions():void{
    this.adminService.getAllCommissionRequests().subscribe(c=>this.commissions=c);
  }

}
