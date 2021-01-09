import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile-creation',
  templateUrl: './profile-creation.component.html',
  styleUrls: ['./profile-creation.component.scss']
})
export class ProfileCreationComponent implements OnInit {

  userObj: User = new User();

  profileForm: any;
  userId: any;
  isUpdate = false;
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. profileForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      roleCode: ['', Validators.required],
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
    this.userObj.userName=object.userName,
    this.userObj.password=object.password,
    this.userObj.email=object.email,
    this.userObj.roleCode=object.roleCode,
    console.log(object);
  }
  onSubmit() {
    console.log("save");

      // this.userService.addAddressookRecord(this.userObj).subscribe(response => {
      //   console.log("response is ", response);
      //   this.router.navigateByUrl('');
      // }, err => {
      // })
    }
  
  reset(): void {
    this.profileForm.reset();
  }
}
