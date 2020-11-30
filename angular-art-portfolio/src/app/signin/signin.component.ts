import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { LoginRequest } from '../Login-Request';
import { TokenStorageService } from '../token-storage.service';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  login:LoginRequest={
    username:'',
    password:'',
  };
  constructor(private auth:AuthService, private tokenStorage:TokenStorageService,private router:Router) { }

  ngOnInit(): void {
  }
  onSubmit(): void{
    this.auth.login(this.login).subscribe(response => {
      this.tokenStorage.saveUser(response);
      this.router.navigate(['dashboard']);
    });
  }

}
