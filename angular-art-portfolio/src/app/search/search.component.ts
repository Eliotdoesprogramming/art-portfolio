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
  
  myImage:Image[];
  
  constructor(private imageService:ImageService) { }

  ngOnInit(): void {
    
  }

  enter(term:string): void{
     this.imageService.searchImage(term).subscribe(results=>this.myImage=results
      );
  }
}
