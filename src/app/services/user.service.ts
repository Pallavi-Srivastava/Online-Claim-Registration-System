import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ResetPassword } from '../models/reset-password';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  private getUrl: string = "http://localhost:7088/onlineinsurancesystem";

  constructor(private _httpClient: HttpClient) { }

  addUserRecord(user: User): Observable<User> {
    return this._httpClient.post<User>(`${this.getUrl}/user/login`, user);
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
