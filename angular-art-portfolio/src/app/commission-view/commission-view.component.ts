import { Component, Input, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { CommissionRequest } from '../commissionRequest';

@Component({
  selector: 'app-commission-view',
  templateUrl: './commission-view.component.html',
  styleUrls: ['./commission-view.component.css']
})
export class CommissionViewComponent implements OnInit {
  @Input() comm:CommissionRequest;
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
  }
  update(status:string): void{
    let updated = false;
    this.adminService.updateCommission(this.comm.id,+status).subscribe(n=>this.comm=n);
    

    
  }


}
