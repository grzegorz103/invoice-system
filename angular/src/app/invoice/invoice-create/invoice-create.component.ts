import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/models/invoice';
import { ServiceService } from 'src/app/services/service.service';
import { Service } from 'src/app/models/service';
import { Router } from '@angular/router';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-invoice-create',
  templateUrl: './invoice-create.component.html',
  styleUrls: ['./invoice-create.component.css']
})
export class InvoiceCreateComponent implements OnInit {

  invoice: Invoice;
  services: Service[];
  selectedService: Service;
  
  constructor(private serviceService: ServiceService,
    private router: Router,
    private invoiceService: InvoiceService) {
    this.invoice = new Invoice();
    this.invoice.services = [];
    this.invoice.totalPrice = 0;

    this.serviceService.findAll().subscribe(res => this.services = res);
  }

  ngOnInit() {
  }

  addServiceToInvoice() {
    this.invoice.totalPrice += this.selectedService.price;
    this.invoice.services.push(this.selectedService);
  }

  removeServiceFromInvoice(index: number) {
    this.invoice.totalPrice -= this.invoice.services[index].price;
    this.invoice.services.splice(index, 1);
  }

  save() {
    this.invoiceService.create(this.invoice).subscribe(res => this.router.navigate(['invoices']));
  }

}
