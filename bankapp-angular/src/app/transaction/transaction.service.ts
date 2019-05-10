import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TransactionService{
    baseUrl = "http://localhost:9090";

    constructor(private http: HttpClient){}

    deposit(accountNumber: number, amount: number){
        return this.http.get(this.baseUrl+"/transaction/deposit/"+accountNumber+"/"+amount);
    }
}