import { Routes } from '@angular/router';
import { DepositComponent } from './transaction-deposit.component';
import { TransactionComponent } from './transaction.component';

export const transactionRoutes: Routes=[
    {path:"transaction", component: TransactionComponent},
    {path:"transaction/deposit", component: DepositComponent}
]