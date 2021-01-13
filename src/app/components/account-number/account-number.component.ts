import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-account-number',
  templateUrl: './account-number.component.html',
  styleUrls: ['./account-number.component.scss']
})
export class AccountNumberComponent implements OnInit {


  @Input("policyId") public roleCode: string;  


  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {

  }

  accountNumber:any;

  ngOnInit(): void {
    console.log("accountNumber oninit ",this.accountNumber);
  }

  onSubmit() {
    console.log("accountNumber onsubmit",this.accountNumber);
    }
  
  reset(): void {
  }
}
