import { UserService } from './../../services/user.service';
import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { element } from 'protractor';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userObj: User = new User();
  validation:boolean;
  loginForm: any;
  userId: any;
  isUpdate = false;
  data:any;
  userNameError: string="";
  passwordError: string="";

  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. loginForm= this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
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
        this.userNameError = 'Invalid Userame';
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

  onSubmit() {
    if(!this.validation){
      console.log(this.validation);//false
      return ;
    }
        console.log(this.validation);//true
        this.userService.addUserRecord(this.userObj).subscribe(response => {
        console.log("response is ", response);
        localStorage.setItem("token", JSON.stringify(response.data));
        this.router.navigateByUrl('/home');
      }, err => {
      })
    }
}
