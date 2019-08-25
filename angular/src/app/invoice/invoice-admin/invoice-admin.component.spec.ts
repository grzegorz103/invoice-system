import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoiceAdminComponent } from './invoice-admin.component';

describe('InvoiceAdminComponent', () => {
  let component: InvoiceAdminComponent;
  let fixture: ComponentFixture<InvoiceAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvoiceAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvoiceAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
