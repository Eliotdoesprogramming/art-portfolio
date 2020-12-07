import { Injectable } from '@angular/core';
import { AppComponent } from './app.component';
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
    window.location.reload();

  }
  getUser():LoginResponse{
    return JSON.parse(    window.sessionStorage.getItem(userKey));
    
  }
  logout():void{
    window.sessionStorage.clear();
    window.location.reload()
  }
}
