import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from './Login-Request';
import { LoginResponse } from './Login-Response';
import { RegistrationRequest } from './registration-request';
import { TokenStorageService } from './token-storage.service';
const httpOption={
  headers:new HttpHeaders({'Content-Type':"application/json"})
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  constructor(private http:HttpClient) { }
  login(user:LoginRequest): Observable<LoginResponse>{
    return this.http.post<LoginResponse>('http://localhost:8080/api/auth/signin',user,httpOption);
  }
  signUp(register:RegistrationRequest):Observable<any>{
    return this.http.post('http://localhost:8080/api/auth/signup',register,httpOption);
  }
}
