import { Component, OnInit } from '@angular/core';
import { FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { Policy } from './../../models/policy';

@Component({
  selector: 'app-create-policy',
  templateUrl: './create-policy.component.html',
  styleUrls: ['./create-policy.component.scss']
})
export class CreatePolicyComponent implements OnInit {
  
  policyObj:Policy=new Policy();

  policyForm: any;
  isUpdate = false;
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. policyForm = this.formBuilder.group({
      policy_number: ['', Validators.required],
      policy_name: ['', Validators.required],
      premium: ['', Validators.required],
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
    console.log(object);
  }
  onSubmit() {
    console.log("save");

      //   console.log("response is ", response);
      //   this.router.navigateByUrl('');
      // }, err => {
      // })
    }
  
  reset(): void {
    this.policyForm.reset();
  }

}
