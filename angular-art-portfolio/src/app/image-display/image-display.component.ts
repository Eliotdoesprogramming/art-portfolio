import { Component, Input, OnInit } from '@angular/core';
import { ImageService } from '../image-service.service';
import {Image} from '../image';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-image-display',
  templateUrl: './image-display.component.html',
  styleUrls: ['./image-display.component.css']
})

export class ImageDisplayComponent implements OnInit {
  @Input() image:Image;
  liked:boolean=false;
  constructor(
    //private imageService: ImageService,
  ) {}


  ngOnInit(): void {
  }


}
