import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap,filter } from 'rxjs/operators';
import {Image} from './image';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private imageUrl = 'http://localhost:8080/api/images';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { 
  }
  getImages(): Observable<Image[]> {
    
    return this.http.get<Image[]>(this.imageUrl).pipe(
    tap(_ => console.log('image service: retrieved images')),
    catchError(this.handleError<Image[]>('getImages',[]))
    ); 
  }
  //will404 if image not found
  getImageById(id: number):Observable<Image>{
    //http://localhost:8080/api/images/2
    let url:string=this.imageUrl+`/${id}`;
      let image:any= this.http.get<Image>(url).pipe(
          tap(image=>console.log(`found image with id ${image.id}`)),
          catchError(this.handleError<Image>('getImageById',null))) 
      return image;
  }


  searchImage(term: string): Observable<Image[]>{
    if(term.trim()===""){
      return of([]);
    }

      
    
    
    return this.http.get<Image[]>(`${this.imageUrl}/search/${term}`).pipe(
      catchError(this.handleError<Image[]>('searchImage',[])),
      tap(
        x=> (x.length>0)? 
        console.log(`found ${x.length} heroes matching ${term}`):
        console.log('found no heroes')  
      )
    );
  }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
}
}
