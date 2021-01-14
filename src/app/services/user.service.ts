import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ResetPassword } from '../models/reset-password';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
const helper=new JwtHelperService();

@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  private getUrl: string = "http://localhost:7088/onlineinsurancesystem";

  constructor(private _httpClient: HttpClient,private router: Router) { }

  headerDict = {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'token':JSON.parse(localStorage.getItem("token"))
  }
  
  logIn(user: User): Observable<User> {
    return this._httpClient.post<User>(`${this.getUrl}/user/login`, user);
  }

  addRecord(user: User): Observable<any> {
    return this._httpClient.post<any>(`${this.getUrl}/user/register`,user,{'headers':this.headerDict});
  }

  forgotPassword(user: User): Observable<User> {
    return this._httpClient.post<User>(`${this.getUrl}/user/forgot`, user);
  }

  resetPassword(user: ResetPassword,data:any): Observable<any> {
    return this._httpClient.post<any>(`${this.getUrl}/user/reset/${data}`,user);
  }

  logOut(): Observable<any> {
    return this._httpClient.get<any>(`${this.getUrl}/user/logout`);
  }
}
