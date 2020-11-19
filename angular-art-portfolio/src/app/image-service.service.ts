import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {Image} from './image';

@Injectable({
  providedIn: 'root'
})
export class ImageServiceService {
  private imageUrl = 'api/images';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { 
  }
  getImages(): Observable<Image[]> {
    // TODO: send the message _after_ fetching the heroes
    return this.http.get(this.imageUrl).pipe(this.handleError<Image[]>('getImages',[]),
    tap(_ => console.log('image service: retrieved images'))); 
      

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
