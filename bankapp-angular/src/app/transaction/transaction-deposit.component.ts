import { Component } from '@angular/core';
import { TransactionService } from './transaction.service';
import { ActivatedRoute } from '@angular/router';


@Component({
    templateUrl: "./transaction-deposit.component.html"
})
export class DepositComponent {

    constructor(private transactionService: TransactionService,
        private route: ActivatedRoute) { }
    ngOnInit() {
        alert("depositcomponent");
    }

    deposit() {
        alert("deposit");
        //  this.route.paramMap.subscribe((map)=>{
        //      let accountNumber = +map.get("accountNumber");
        //      let amount = +map.get("amount");
        //  console.log(accountNumber);
        let accountNumber = +(<HTMLInputElement>document.getElementById("accountNumber")).value;
        let amount = +(<HTMLInputElement>document.getElementById("amount")).value;
        console.log(accountNumber);
        this.transactionService.deposit(accountNumber, amount).subscribe((data) => {
            alert("deposited");
        });
        //  });
    }
}