import { Component, OnInit } from '@angular/core';
import { BankAccount } from './account';
import { AccountService } from './account.service';

@Component({
    templateUrl: "./account-list.component.html"
})
export class AccountsListComponent implements OnInit{
    accounts: BankAccount[];
    constructor(private accountService: AccountService){}
    
    ngOnInit():void{
        this.accountService.getAllAccounts().subscribe((data)=>{
            this.accounts = data;
          });
    }
        
      
}