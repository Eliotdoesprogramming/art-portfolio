import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { CommissionRequest } from '../commissionRequest';

@Component({
  selector: 'app-pending-commission-view',
  templateUrl: './pending-commission-view.component.html',
  styleUrls: ['./pending-commission-view.component.css']
})
export class PendingCommissionViewComponent implements OnInit {
  commissions:CommissionRequest[];
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
      this.getPendingCommissions();
  }
  getPendingCommissions():void{
    this.adminService.getPendingCommissionRequests().subscribe(c=>this.commissions=c);
  }

}
