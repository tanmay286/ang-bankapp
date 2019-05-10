import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AccountModule } from './account/account.module';

import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AccountComponent } from './account/account.component';

@NgModule({
  declarations: [
    AppComponent
  
  ],
  imports: [
    BrowserModule,
   AccountModule,
   FormsModule,
   RouterModule.forRoot(
    [
      { path: "", component: AccountComponent}
    ]
  )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
