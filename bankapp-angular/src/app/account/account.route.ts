import { Routes } from "@angular/router";
import { AccountsListComponent } from './account-list.component';
import { TransactionComponent } from '../transaction/transaction.component';

export const accountRoutes : Routes=[
   {path: "accounts", component:AccountsListComponent},
   {path: "transaction", component: TransactionComponent}
]