import { NgModule } from '@angular/core';
import { TransactionComponent } from './transaction.component';
import { DepositComponent } from './transaction-deposit.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { transactionRoutes } from './transaction.routes';
import { TransactionService } from './transaction.service';

@NgModule({
    declarations:[TransactionComponent, DepositComponent],
    imports:[BrowserModule, HttpClientModule, FormsModule,
             RouterModule.forChild(transactionRoutes)],
    exports:[TransactionComponent, DepositComponent, RouterModule],
    providers:[TransactionService]
})
export class TransactionModule{

}