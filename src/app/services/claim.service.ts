import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {

  constructor(private http:HttpClient) { }

  

  private getUrl: string = "http://ec2-3-17-191-27.us-east-2.compute.amazonaws.com:7088/onlineinsurancesystem";

  createClaim(policyNumber:any,claimObj:any){
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'token':JSON.parse(localStorage.getItem("token"))
    }
    return this.http.post<any>(`${this.getUrl}/claim/create/${policyNumber}`,claimObj,{'headers':headerDict});
  }

  getUserInsuredClaims(){
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'token':JSON.parse(localStorage.getItem("token"))
    }
      return this.http.get<any>(`${this.getUrl}/claim/get`,{'headers':headerDict})
  }

}
