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

    private getUrl: string = "http://localhost:7088/onlineinsurancesystem";


  createPolicy(data: any){
    return this.http.post<any>(`${this.getUrl}/policy/create`,data,{'headers':this.headerDict});
  }

  getAllAvailablePolicies(){
    return this.http.get<any>(`${this.getUrl}/policy`,{'headers':this.headerDict});
  }

  registerPolicy(policyId:any){
    return this.http.post<any>(`${this.getUrl}/userpolicy/register/${policyId}`," ",{'headers':this.headerDict});
  }

  getUserInsuredPolicies(){
    return this.http.get<any>(`${this.getUrl}/userpolicy/get`,{'headers':this.headerDict});
  }

}
