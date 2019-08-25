import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Invoice } from '../invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  url = 'http://localhost:8080/api/invoices/';

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Invoice[]>(this.url);
  }

  findByUser() {
    return this.http.get<Invoice>(this.url + 'byUser');
  }

  create(invoice: Invoice) {
    return this.http.post<Invoice>(this.url, invoice);
  }

  updateStatus(id: number) {
    return this.http.patch<Invoice>(this.url + id, null);
  }

  deleteById(id: number) {
    this.http.delete(this.url + id).subscribe(res => console.log(res));
  }
}
