
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ProfileCreationComponent } from './components/profile-creation/profile-creation.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClaimCreationComponent } from './components/claim-creation/claim-creation.component';
import { ViewPoliciesComponent } from './components/view-policies/view-policies.component';
import { ReportGenerationComponent } from './components/report-generation/report-generation.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { CreatePolicyComponent } from './components/create-policy/create-policy.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterPolicyComponent } from './components/register-policy/register-policy.component';
import { ViewClaimsComponent } from './components/view-claims/view-claims.component';
import { AccountNumberComponent } from './components/account-number/account-number.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"fogot-password",component:ForgotPasswordComponent},
  {path:'reset-password/:token',component:ResetPasswordComponent},
  {path:"home",component:HomeComponent,
      children:[
        {path:'',redirectTo:'home', pathMatch:'full'},
        {path:'profile-creation',component:ProfileCreationComponent},
        {path:"view-policies",component:ViewPoliciesComponent},
        {path:"report-generation",component:ReportGenerationComponent},
        {path:"claim-creation",component:ClaimCreationComponent},
        {path:"claim-creation/:policyNumber",component:ClaimCreationComponent},
        {path:"view-available-polices",component:RegisterPolicyComponent},
        {path:"view-claims",component:ViewClaimsComponent},
        {path:"create-policy",component:CreatePolicyComponent},
        {path:"account-number",component:AccountNumberComponent},
      ],canActivateChild:[AuthGuard],canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
