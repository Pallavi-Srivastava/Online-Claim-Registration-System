import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private getUrl: string = "http://localhost:7039/User";

  constructor(private http: HttpClient) { }

  getUserList(){
    return this.http.get(`${this.getUrl}/get`);
  }

  getUser(id: any){
    return this.http.get(`${this.getUrl}/get/` + id);
  }

  createUser(data: any){
    return this.http.post(`${this.getUrl}/create`,data);
  }

  updateUser(data: any){
    return this.http.put(`${this.getUrl}/update/`,data);
  }

  deleteUser(id: any){
    return this.http.delete(`${this.getUrl}/delete/` + id);
  }
}
