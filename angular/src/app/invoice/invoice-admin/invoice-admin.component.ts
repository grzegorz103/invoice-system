import { Component, OnInit } from '@angular/core';
import { InvoiceService } from 'src/app/services/invoice.service';
import { Invoice } from 'src/app/models/invoice';

@Component({
  selector: 'app-invoice-admin',
  templateUrl: './invoice-admin.component.html',
  styleUrls: ['./invoice-admin.component.css']
})
export class InvoiceAdminComponent implements OnInit {

  invoices: Invoice[];

  constructor(private invoiceService: InvoiceService) { 
  }

  ngOnInit() {
    this.invoiceService.findAll().subscribe(res=>this.invoices=res);
  }

  changeStatus(index: number){
    this.invoiceService.updateStatus(this.invoices[index].id).subscribe(res=>this.ngOnInit());
  }
}
