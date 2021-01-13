import { Component, OnInit } from '@angular/core';
import { FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PolicyService } from 'src/app/services/policy.service';
import { Policy } from './../../models/policy';

@Component({
  selector: 'app-create-policy',
  templateUrl: './create-policy.component.html',
  styleUrls: ['./create-policy.component.scss']
})
export class CreatePolicyComponent implements OnInit {
  
  policyObj:Policy=new Policy();
  policyForm!: FormGroup;
  isUpdate = false;
  token:any;
  constructor(private formBuilder: FormBuilder,
              private PolicyService: PolicyService,
              private router: Router,
              private activatedRoute: ActivatedRoute){}

      ngOnInit():void{
        console.log("ng on it ")
        this.policyForm=this.formBuilder.group({
          policyName:['',Validators.compose([Validators.required, Validators.minLength(2),
                                              Validators.pattern('^[A-Z][a-zA-Z\\s]{2,}$')])],
          premium:['',Validators.compose([Validators.required, Validators.min(1000)])]
        })

      }

      onSubmit() {
        console.log("on submit")
        this.createPolicy();
      }

      createPolicy(){


      
        if (!this.formValid()) return;
        var policyDTO={
          'policyName':this.policyForm.controls['policyName'].value,
          'premium':this.policyForm.controls['premium'].value
        }
        
        console.log(policyDTO);
        this.PolicyService.createPolicy(policyDTO).subscribe((response:any)=>{
            this.router.navigate(["/home/view-available-polices"]);
            console.log("create policy response ",response);
        })
         
      }

      formValid():boolean{
        if(this.policyForm.controls['policyName'].valid&&
          this.policyForm.controls['premium'].valid){
            console.log("form valid is true");
             return true;
          }
        this.policyForm.markAllAsTouched();
        console.log("form valid is false");
        return false;
      }
  
      reset(): void {
        this.policyForm.reset();
      }

}
