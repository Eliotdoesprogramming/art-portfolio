import { Component, OnInit } from '@angular/core';
import { ImageService } from '../image-service.service';
import {Image} from '../image'
@Component({
  selector: 'app-display-all-images',
  templateUrl: './display-all-images.component.html',
  styleUrls: ['./display-all-images.component.css']
})
export class DisplayAllImagesComponent implements OnInit {
  images: Image[];
  
  constructor(private imageService:ImageService) { }

  ngOnInit(): void {
    this.getImages();
  }
  getImages(): void{
    this.imageService.getImages().subscribe(images=>this.images=images);   
  }
}
