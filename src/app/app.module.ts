import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClaimSideNavbarComponent } from './components/claim-side-navbar/claim-side-navbar.component';
import { ButtonComponent } from './components/button/button.component';
import { PolicySideNavbarComponent } from './components/policy-side-navbar/policy-side-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ClaimSideNavbarComponent,
    ButtonComponent,
    PolicySideNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
