import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BankAccount } from './account';
import { Observable } from 'rxjs';

@Injectable()
export class AccountService{
   
    baseUrl = "http://localhost:8080";
    headers = new HttpHeaders({'Access-Control-Allow-Origin' : '*'})
    constructor( private http:HttpClient){}

    getAllAccounts(){
        return this.http.get<BankAccount[]>(this.baseUrl+"/account");
    }

    addNewAccount(account:BankAccount):Observable<BankAccount>{
        console.log(account);
        return this.http.post<BankAccount>(this.baseUrl+"/account",account,
        {headers: this.headers});
    }
}