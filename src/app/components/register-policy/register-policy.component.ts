import { Component, OnInit, Input } from '@angular/core';
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

  @Input("roleCode") public roleCode: string;  


  availablePolicies:Array<any>;
  accountNumber:any;
  policy :Policy =new Policy();
  policyId:any;

  ngOnInit(): void {
    this.getAllAvailablePolices();
    this.roleCode=JSON.parse(localStorage.getItem("RoleCode"));
    console.log("roleCode ",this.roleCode)
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
