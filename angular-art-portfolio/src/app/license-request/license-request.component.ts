import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Request} from '../request'
import { RequestService} from '../request.service'

@Component({
  selector: 'app-license-request',
  templateUrl: './license-request.component.html',
  styleUrls: ['./license-request.component.css']
})
export class LicenseRequestComponent implements OnInit {
  id:number;

  constructor(private reqService: RequestService,
              private route: ActivatedRoute,
              ) { }

  ngOnInit(): void {
    this.getImage();
  }
  getImage():void{
    this.id = +this.route.snapshot.paramMap.get('id');
  }
  submit(name:string,email:string,business:string,description:string){
    let toSubmit:Request={
      id:0,
      imageId:this.id,
      name:name,
      email:email,
      business:business,
      description:description
    }
    this.reqService.addRequest(toSubmit).subscribe(_=>console.log(`added  license request`));
    // this.heroService.addHero({ name } as Hero)
    // .subscribe(hero => {
    //   this.heroes.push(hero);
    // });
  }
}
