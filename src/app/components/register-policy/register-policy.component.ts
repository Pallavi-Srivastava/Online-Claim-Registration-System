import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyService } from 'src/app/services/policy.service';
import { Policy } from './../../models/policy';

@Component({
  selector: 'app-register-policy',
  templateUrl: './register-policy.component.html',
  styleUrls: ['./register-policy.component.scss']
})
export class RegisterPolicyComponent implements OnInit {

  constructor(private router:Router, private policyService:PolicyService) { }

  availablePolicies:Array<any>;
  accountNumber:any;
  policy :Policy =new Policy();
  policyId:any;

  ngOnInit(): void {
    this.getAllAvailablePolices();
  }

  getAllAvailablePolices(){
      this.policyService.getAllAvailablePolicies().subscribe(response =>{
        console.log("policyId ",response.policyId);
        this.availablePolicies=response.data;
        console.log("availablePolicies ",this.availablePolicies);
      })
  }

  registerPolicy(policies:any){
    console.log("policy ",policies);
    this.policyId=policies.policyId;
    console.log("policyId ",this.policyId);
    this.policyService.registerPolicy(this.policyId).subscribe((response:any) =>{
        console.log("response ",response);
        this.router.navigate(["/home/view-policies"]);
    })

  }

}
