import { Injectable } from '@angular/core';
import { LoginResponse } from './Login-Response';
const userKey:string = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }
  saveUser(response:LoginResponse): void{
    window.sessionStorage.removeItem(userKey);
    window.sessionStorage.setItem(userKey,JSON.stringify(response));
  }
  getUser():LoginResponse{
    return JSON.parse(    window.sessionStorage.getItem(userKey));
  }
  logout():void{
    window.sessionStorage.clear();
  }
}
