import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './public/register/register.component';
import { LoginComponent } from './public/login/login.component';
import { IndexComponent } from './shared/index/index.component';
import { InvoiceDetailsComponent } from './invoice/invoice-details/invoice-details.component';
import { InvoiceCreateComponent } from './invoice/invoice-create/invoice-create.component';
import { InvoiceListComponent } from './invoice/invoice-list/invoice-list.component';
import { InvoiceAdminComponent } from './invoice/invoice-admin/invoice-admin.component';
import { ServiceListComponent } from './service/service-list/service-list.component';
import { ServiceCreateComponent } from './service/service-create/service-create.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'invoices/create', component: InvoiceCreateComponent },
  { path: 'invoices/:id/details', component: InvoiceDetailsComponent },
  { path: 'invoices', component: InvoiceListComponent },
  { path: 'invoices/admin', component: InvoiceAdminComponent },
  { path: 'services', component: ServiceListComponent },
  { path: 'services/create', component: ServiceCreateComponent},
  { path: '', component: IndexComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
