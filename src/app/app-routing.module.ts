import { ProfileCreationComponent } from './components/profile-creation/profile-creation.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClaimSideNavbarComponent } from './components/claim-side-navbar/claim-side-navbar.component';
import { PolicySideNavbarComponent } from './components/policy-side-navbar/policy-side-navbar.component';
import { ClaimCreationComponent } from './components/claim-creation/claim-creation.component';
import { ViewPoliciesComponent } from './components/view-policies/view-policies.component';
import { ReportGenerationComponent } from './components/report-generation/report-generation.component';
import { CreatePolicyComponent } from './components/create-policy/create-policy.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterPolicyComponent } from './components/register-policy/register-policy.component';
import { ViewClaimsComponent } from './components/view-claims/view-claims.component';
import { AccountNumberComponent } from './components/account-number/account-number.component';

const routes: Routes = [

  {path:"",component:LoginComponent},

  {path:"home",component:HomeComponent,
      children:[
        {path:'',redirectTo:'home', pathMatch:'full'},
        {path:'profile-creation',component:ProfileCreationComponent},
        {path:"view-policies",component:ViewPoliciesComponent},
        {path:"report-generation",component:ReportGenerationComponent},
        {path:"claim-creation",component:ClaimCreationComponent},
        {path:"view-available-polices",component:RegisterPolicyComponent},
        {path:"view-claims",component:ViewClaimsComponent},
        {path:"create-policy",component:CreatePolicyComponent},
        {path:"account-number",component:AccountNumberComponent},

      ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
