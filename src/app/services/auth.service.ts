import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
const helper=new JwtHelperService();

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router) { }

  isAuthorised(){
    if(String(localStorage.getItem('token'))== '' || String(localStorage.getItem('token'))== 'null'){
      this.router.navigate(['']);
      return false;
    }
    const isExpired=helper.isTokenExpired(String(localStorage.getItem('token')));
    if(isExpired){
      alert("Session Expired, Login Again");
      this.router.navigate(['']);
      return false;
    }
    return true;
  }
}
