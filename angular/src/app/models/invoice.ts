import { Service } from './service';
import { InvoiceStatus } from './invoice-status';

export class Invoice {
    id: number;
    totalPrice: number;
    services: Service[];
    invoiceStatus: InvoiceStatus;
}
