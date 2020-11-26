import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { CommissionRequest } from './commissionRequest';
import { GrantedLicense } from './grantedLicense';
import {LicenseRequest} from './licenseRequest'

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private url = 'http://localhost:8080/api/admin';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { }

  getAllLicenseRequests(): Observable<LicenseRequest[]>{
    return this.http.get<LicenseRequest[]>(this.url+`/licenseReqs`).pipe(
      tap(_ => console.log('admin service: retrieved lqrs')),
      catchError(this.handleError<LicenseRequest[]>('getAllLicenseRequests',[]))
      );    
  }
  getPendingLicenseRequests(): Observable<LicenseRequest[]>{
    return this.http.get<LicenseRequest[]>(this.url+`/licenseReqs/pending`).pipe(
      tap(_ => console.log('admin service: retrieved lqrs')),
      catchError(this.handleError<LicenseRequest[]>('getAllLicenseRequests',[]))
      );    
  }
  grantLicense(id:number):Observable<boolean>{
    return this.http.post<boolean>(this.url+`/grantLicense/${id}`,"",this.httpOptions).pipe(
      tap(_ => console.log('admin service: granted license')),
      catchError(this.handleError<boolean>('getAllLicenseRequests',false))
      );
  }
  getAllCommissionRequests(): Observable<CommissionRequest[]>{
    return this.http.get<CommissionRequest[]>(this.url+`/commissions`).pipe(
      tap(_ => console.log('admin service: retrieved commreqs')),
      catchError(this.handleError<CommissionRequest[]>('getAllLicenseRequests',[]))
      ); 
  }
  ///commissions/pending
  getPendingCommissionRequests(): Observable<CommissionRequest[]>{
    return this.http.get<CommissionRequest[]>(this.url+`/commissions/pending`).pipe(
      tap(_ => console.log('admin service: retrieved  pending commreqs')),
      catchError(this.handleError<CommissionRequest[]>('getAllLicenseRequests',[]))
      ); 
  }

  //   /commission/update/{id}/{status}
  updateCommission(id:number,status:number):Observable<CommissionRequest>{
    return this.http.put<CommissionRequest>(this.url+`/commission/update/${id}/${status}`,"",this.httpOptions).pipe(
      tap(_ => console.log('admin service: retrieved  pending commreqs')),
      catchError(this.handleError<CommissionRequest>('getAllLicenseRequests',null))
      );
  }
  getGrantedLicenses(): Observable<GrantedLicense[]>{
    return this.http.get<GrantedLicense[]>(this.url+`/viewLicenses`).pipe(
      tap(_ => console.log('admin service: retrieved  grantedLicenses')),
      catchError(this.handleError<GrantedLicense[]>('getGrantedLicenses',[]))
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
