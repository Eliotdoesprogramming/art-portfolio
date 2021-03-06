import { Component, OnInit } from '@angular/core';
import { CommissionRequest } from '../commissionRequest';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-commission',
  templateUrl: './commission.component.html',
  styleUrls: ['./commission.component.css']
})
export class CommissionComponent implements OnInit {

  constructor(private reqService:RequestService) { }

  ngOnInit(): void {
  }
  submit(name:string,email:string,description:string){
    if(email.includes('@'))
    {let toSubmit:CommissionRequest={
      id:0,  
      name:name,
      email:email,
      description:description,
      status:'PENDING'
    }
    this.reqService.addCommisionRequest(toSubmit).subscribe(id=>alert(`added request with id ${id}`));}
    else alert('invalid email address');
}
}
