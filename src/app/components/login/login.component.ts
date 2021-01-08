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

  signInForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private route: Router,) {}

  ngOnInit() {
    this.signInForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(8)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      }, {});
    }

  signIn=(signInFormValue: { username: any; password: any; })=> {
    this.submitted = true;

    if (this.signInForm.invalid) return;
      
    let user={
      username: signInFormValue.username,
      password: signInFormValue.password,
    }
        
    // this.userService.loginUser(user).subscribe((response: any) => {
    //   console.log("Successful sign in: ", response);
    //   localStorage.setItem("token", response.id);
    //   this.route.navigate(['/dashboard']);
    // });
  }
}
