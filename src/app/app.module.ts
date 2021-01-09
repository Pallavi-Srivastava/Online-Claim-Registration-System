import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card'; 
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatRadioModule} from '@angular/material/radio'; 
import {MatCheckboxModule} from '@angular/material/checkbox'; 
import {MatSliderModule} from '@angular/material/slider';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import { ClaimCreationComponent } from './components/claim-creation/claim-creation.component';
import { HeaderComponent } from './components/header/header.component';
import { ClaimSideNavbarComponent } from './components/claim-side-navbar/claim-side-navbar.component';
import { ButtonComponent } from './components/button/button.component';
import { PolicySideNavbarComponent } from './components/policy-side-navbar/policy-side-navbar.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileCreationComponent } from './components/profile-creation/profile-creation.component';
import { ViewPoliciesComponent } from './components/view-policies/view-policies.component';
import {MatIconModule} from '@angular/material/icon';
import { ReportGenerationComponent } from './components/report-generation/report-generation.component';
import { CreatePolicyComponent } from './components/create-policy/create-policy.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ClaimCreationComponent,
    HeaderComponent,
    ClaimSideNavbarComponent,
    ButtonComponent,
    PolicySideNavbarComponent,
    HomeComponent,
    ProfileCreationComponent,
    ViewPoliciesComponent,
    ReportGenerationComponent,
    CreatePolicyComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FlexLayoutModule,
    MatRadioModule,
    MatCheckboxModule,
    MatSliderModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
