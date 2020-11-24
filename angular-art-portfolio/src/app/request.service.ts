import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { CommissionRequest } from './commissionRequest';
import {LicenseRequest } from './licenseRequest'

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private requestUrl ='http://localhost:8080/api/licenseRequest';
  private commUrl = 'http://localhost:8080/api/commissionRequest';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http:HttpClient) { }
  
  addLicenseRequest(req: LicenseRequest) {
    return this.http.post<LicenseRequest>(this.requestUrl+`/add`, req, this.httpOptions).pipe(
      tap((newreq: LicenseRequest) => console.log(`added request w/ id=${newreq.id}`)),
      catchError(this.handleError<LicenseRequest>('addRequest'))
    );
  }
  addCommisionRequest(req:CommissionRequest){
    return this.http.post<CommissionRequest>(this.commUrl+`/add`,req,this.httpOptions).pipe(
      tap((newReq:CommissionRequest)=>console.log(`added request with id = ${newReq.id}`)
      ,catchError(this.handleError<CommissionRequest>('addCommisionRequest')))
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
