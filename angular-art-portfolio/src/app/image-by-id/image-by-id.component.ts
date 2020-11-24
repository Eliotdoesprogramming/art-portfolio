import { Component, OnInit } from '@angular/core';
import { Image } from '../image';
import { ActivatedRoute } from '@angular/router';
import { ImageService } from '../image-service.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-image-by-id',
  templateUrl: './image-by-id.component.html',
  styleUrls: ['./image-by-id.component.css']
})
export class ImageByIdComponent implements OnInit {
  image:Image;
  constructor(private route:ActivatedRoute, private imgService:ImageService) { }

  ngOnInit(): void {
    this.getImage();
  }
  getImage():void{
    
      let id:number= +this.route.snapshot.paramMap.get('id');
      this.imgService.getImageById(id).subscribe(recieved => this.image=recieved);
  }

}
