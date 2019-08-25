import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { RegisterComponent } from './public/register/register.component';
import { LoginComponent } from './public/login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserService } from './services/user.service';
import { IndexComponent } from './shared/index/index.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HttpRequestInterceptor } from './security/request-interceptor';
import { InvoiceListComponent } from './invoice/invoice-list/invoice-list.component';
import { InvoiceDetailsComponent } from './invoice/invoice-details/invoice-details.component';
import { InvoiceCreateComponent } from './invoice/invoice-create/invoice-create.component';
import { ServiceListComponent } from './service/service-list/service-list.component';
import { ServiceCreateComponent } from './service/service-create/service-create.component';
import { InvoiceAdminComponent } from './invoice/invoice-admin/invoice-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    IndexComponent,
    FooterComponent,
    InvoiceListComponent,
    InvoiceDetailsComponent,
    InvoiceCreateComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    InvoiceAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [UserService, {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpRequestInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
