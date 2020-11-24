import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import {Request } from './request'

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private requestUrl ='http://localhost:8080/api/licenseRequest';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http:HttpClient) { }
  
  addRequest(req: Request) {
    return this.http.post<Request>(this.requestUrl+`/add`, req, this.httpOptions).pipe(
      tap((newreq: Request) => console.log(`added request w/ id=${newreq.id}`)),
      catchError(this.handleError<Request>('addRequest'))
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
