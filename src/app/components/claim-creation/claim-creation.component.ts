import { Claim } from './../../models/claim';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

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
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. claimForm = this.formBuilder.group({
      claimReason: ['', Validators.required],
      accidentLocationStreet: ['', Validators.required],
      accidentCity: ['', Validators.required],
      accidentState: ['', Validators.required],
      accidentZip: ['', Validators.required],
      claimType: ['', Validators.required],
      id: ['']
    });

    this.activatedRoute.params.subscribe(data => {
      if (data && data.id) {
        //for required  Validation
       // this.getDataById(data.id)
      }
    })

  }

  ngOnInit() {
    console.log("claimForm ",this.claimForm)
    console.log("policyNumber ",this.policyNumber)
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
    this.claimObj.accidentLocationStreet=object.accidentLocationStreet,
    this.claimObj.accidentCity=object.accidentCity,
    this.claimObj.accidentState=object.accidentState,
    this.claimObj.accidentZip=object.accidentLocationStreet,
    this.claimObj.claimType=object.claimType,
    console.log(object);
  }
  onSubmit() {
    console.log("save");

      this.userService.createClaim(this.claimObj).subscribe(response => {
        console.log("response is ", response);
        this.router.navigateByUrl('');
      }, err => {
      })
    }
  
  reset(): void {
    this.claimForm.reset();
  }

}
