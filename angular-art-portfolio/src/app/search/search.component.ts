import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import {Image} from '../image'
import { ImageService } from '../image-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  images$: Observable<Image[]>;
  myImage:Image[];
  
  constructor(private imageService:ImageService) { }

  ngOnInit(): void {
    this.images$ = this.imageService.getImages();
  }

  enter(term:string): void{
     this.images$.subscribe(n => this.myImage=n);
     this.myImage.filter(image =>image.name === term);
  }
}
