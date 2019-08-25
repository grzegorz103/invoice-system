import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {

  service: Service;

  constructor(private serviceService: ServiceService,
    private router: Router) {
    this.service = new Service();
  }

  ngOnInit() {
  }

  create() {
    this.serviceService.create(this.service)
      .subscribe(res =>this.router.navigate(['services']));
  }

}
