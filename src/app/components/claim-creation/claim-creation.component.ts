import { Claim } from './../../models/claim';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClaimService } from 'src/app/services/claim.service';

@Component({
  selector: 'app-claim-creation',
  templateUrl: './claim-creation.component.html',
  styleUrls: ['./claim-creation.component.scss']
})
export class ClaimCreationComponent implements OnInit {

  claimObj: Claim = new Claim();

  @Input("policyNumber") public policyNumber:any;

  claimForm: any;
  claimNumber: any;
  isUpdate = false;
  constructor(private formBuilder: FormBuilder, private claimService:ClaimService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. claimForm = this.formBuilder.group({
      claimReason: ['', Validators.required],
      street: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      zipcode: ['', Validators.required],
      claimType: ['', Validators.required],
      id: ['']
    });

    this.activatedRoute.params.subscribe(data => {
      console.log("data ",data.policyNumber)
      this.policyNumber=data.policyNumber;
      console.log("data policyNumber ",this.policyNumber);
    })

  }

  ngOnInit() {
    
  }

  getErrorMessage(control: FormControl, message: string) {
    if (control.errors) {
      if (control.errors.required) {
        return message + ' is required';
      }

      if (control.errors.pattern || control.errors.whitespace) {
        return 'Invalid ' + message.toLowerCase();
      }
    }
  }

  private markFormGroupTouched(formGroup: FormGroup) {
    (<any>Object).values(formGroup.controls).forEach(control => {
      control.markAsTouched();
      if (control.controls) {
        this.markFormGroupTouched(control);
      }
    });
  }

  // getDataById(id): void {
  //   this.userService.getAddressBookById(id).subscribe(respose => {
  //   this.setDataToFormBuilder(respose.data);
  //   }, err => {
  //     console.log("User Record");
  //   })
  // }

  setDataToFormBuilder(object): void { 
    this.claimObj.claimReason=object.claimReason,
    this.claimObj.street=object.street,
    this.claimObj.city=object.city,
    this.claimObj.state=object.state,
    this.claimObj.zipcode=object.zipcode,
    this.claimObj.claimType=object.claimType,
    console.log(object);
  }

  onSubmit() {
    console.log("policyNumber ",this.policyNumber)
    this.setDataToFormBuilder(this.claimObj);

      this.claimService.createClaim(this.policyNumber, this.claimObj).subscribe(response => {
        console.log("response is ", response);
        this.router.navigate(["/home/view-claims"]);
      }, err => {
        console.log("error")
      })
    }
  
  reset(): void {
    this.claimForm.reset();
  }

}
