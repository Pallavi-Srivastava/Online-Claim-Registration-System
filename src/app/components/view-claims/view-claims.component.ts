import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimService } from 'src/app/services/claim.service';
import { Claim } from './../../models/claim';
import { Policy } from './../../models/policy';

@Component({
  selector: 'app-view-claims',
  templateUrl: './view-claims.component.html',
  styleUrls: ['./view-claims.component.scss']
})
export class ViewClaimsComponent implements OnInit {

 
  userInsuredClaims:Array<any>;
  policy :Policy =new Policy();
  claim :Claim =new Claim();
  policyNumber:any;
  userPolicy:any;

  constructor(private router:Router, private claimService:ClaimService) { }

  ngOnInit(): void {
    this.getUserInsuredClaims();
  }

  getUserInsuredClaims(){
    this.claimService.getUserInsuredClaims().subscribe(response =>{
      this.userInsuredClaims=response.data;
      console.log("response.data ",this.userInsuredClaims);
    })
  }

  getPolicyNumber(policy:any){
    console.log(policy)
  }


}
