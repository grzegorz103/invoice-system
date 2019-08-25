import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/services/service.service';
import { Service } from 'src/app/models/service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  services: Service[];

  constructor(private serviceService: ServiceService) {
    this.serviceService.findAll()
      .subscribe(res => this.services = res);
  }

  ngOnInit() {
  }

}
