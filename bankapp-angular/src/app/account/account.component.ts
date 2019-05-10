import { Component, OnInit } from '@angular/core';
import { BankAccount } from './account';
import {AccountService} from './account.service';

@Component({
    templateUrl:'./account.component.html'
    // selector:"account-component"
})
export class AccountComponent implements OnInit{
  account:BankAccount;

  constructor(private accountService: AccountService){}
  ngOnInit(){
      this.account= new BankAccount();
  }

  

  addNewAccount(){
      alert("method");
        console.log(this.account);
      this.accountService.addNewAccount(this.account).subscribe((data)=>{
           console.log("success");
           if(data!=null){
              alert("done");
              
           }
      });
  }
}