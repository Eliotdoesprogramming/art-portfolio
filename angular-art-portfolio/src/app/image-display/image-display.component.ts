import { Component, OnInit } from '@angular/core';
import { ImageService } from '../image-service.service';
import {Image} from '../image';


@Component({
  selector: 'app-image-display',
  templateUrl: './image-display.component.html',
  styleUrls: ['./image-display.component.css']
})
export class ImageDisplayComponent implements OnInit {
  image:Image;
  constructor(private imageService:ImageService) { }
  
  ngOnInit(): void {
  }

}
