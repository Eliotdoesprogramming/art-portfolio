import { tokenName } from '@angular/compiler';
import { Component, Input } from '@angular/core';
import { AuthService } from './auth.service';
import { TokenStorageService } from './token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @Input() userName:string= "";
  title = "";
  constructor(){}
  setUserName(user:string){
    this.userName=user;
  }

}
