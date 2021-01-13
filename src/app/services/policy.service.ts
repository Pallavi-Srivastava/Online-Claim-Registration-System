import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http:HttpClient) { }

     headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'token':JSON.parse(localStorage.getItem("token"))
    }

  createPolicy(data: any){
    return this.http.post<any>('http://localhost:7088/onlineinsurancesystem/policy/create',data,{'headers':this.headerDict});
  }


}
