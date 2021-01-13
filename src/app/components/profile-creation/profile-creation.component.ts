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
  validation:boolean;
  userNameError: string="";
  passwordError: string="";
  emailError: string="";
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. profileForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      roleCode: ['', Validators.required],
      id: ['']
    });
  }

  ngOnInit() {
  }

  onUserNameChange() {
    let userNameRegex = RegExp('^(?=[a-zA-Z0-9.@_]{6,20}$)(?!.*[_.]{2})[^_.].*[^_.]$');
    if (userNameRegex.test(this.userObj.userName)){
        this.userNameError = "";
        this.validation=true;
    } else {
        this.userNameError = 'Invalid Login-Id';
        this.validation=false;
    }
  }

  onPasswordChange() {
    const passwordRegex = RegExp('^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$');
    if (passwordRegex.test(this.userObj.password)){
        this.passwordError = "";
        this.validation=true;
    } else{
        this.passwordError = 'Invalid Password.';
        this.validation=false;
    }
  }

  onEmailChange() {
    let emailRegex = RegExp('^([a-z0-9]+[-._+]?[a-z0-9]+)+@[a-z0-9-]+.[a-z]{2,3}.[a-z]{2,3}$');
    if (emailRegex.test(this.userObj.email)){
        this.emailError = "";
        this.validation=true;
    } else {
        this.emailError = 'Invalid email';
        this.validation=false;
    }
  }

  onSubmit() {
    if(!this.validation){
      console.log("Profile Creation:",this.validation);//false
      return ;
    }else{
      console.log("Profile Creation:",this.validation);
    }

    console.log("RegisterPerson");
      this.userService.addRecord(this.userObj).subscribe(response => {
        console.log("response is ", response);
        alert("Account has been successfully created");
        localStorage.clear();
        this.router.navigateByUrl('');
      }, err => {
      })
    }
  
  reset(): void {
    this.profileForm.reset();
  }
}
