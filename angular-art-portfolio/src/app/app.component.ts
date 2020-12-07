import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { TokenStorageService } from './token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userName:string ="";
  title = "";
  constructor(private token:TokenStorageService){}
  getUserName(){
    this.token.getUser()
  }
}
