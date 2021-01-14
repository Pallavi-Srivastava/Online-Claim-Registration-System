import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Policy } from 'src/app/models/policy';
import { PolicyService } from 'src/app/services/policy.service';

@Component({
  selector: 'app-view-policies',
  templateUrl: './view-policies.component.html',
  styleUrls: ['./view-policies.component.scss']
})
export class ViewPoliciesComponent implements OnInit {

  userInsuredPolicies:Array<any>;
  policy :Policy =new Policy();
  userPolicyNumber:any;

  constructor(private router:Router, private policyService:PolicyService) { }

  ngOnInit(): void {
    this.getUserInsuredPolicies();
  }

  getUserInsuredPolicies(){
    this.policyService.getUserInsuredPolicies().subscribe(response =>{
      this.userInsuredPolicies=response.data;
      console.log("userInsuredPolicies ",this.userInsuredPolicies);
    })
  }

  getUserPolicyNumber(policy:any){
    console.log("view-policies userPolicyId ",policy.userPolicyId)
    this.userPolicyNumber=policy.userPolicyId;
  }

}
