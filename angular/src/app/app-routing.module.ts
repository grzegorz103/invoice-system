import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './public/register/register.component';
import { LoginComponent } from './public/login/login.component';
import { IndexComponent } from './shared/index/index.component';
import { InvoiceDetailsComponent } from './invoice-details/invoice-details.component';
import { InvoiceCreateComponent } from './invoice-create/invoice-create.component';
import { InvoiceListComponent } from './invoice-list/invoice-list.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'invoices/create', component: InvoiceCreateComponent },
  { path: 'invoices/:id/details', component: InvoiceDetailsComponent },
  { path: 'invoices', component: InvoiceListComponent },
  { path: '', component: IndexComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
