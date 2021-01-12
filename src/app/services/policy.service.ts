import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http:HttpClient) { }

  createPolicy(data: any){
    return this.http.post('http://localhost:7088/onlineinsurancesystem/policy/create',data);
  }
}
