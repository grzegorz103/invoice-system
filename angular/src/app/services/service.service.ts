import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Service } from '../models/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  url = 'http://localhost:8080/api/services/';

  constructor(private http: HttpClient) { }

  findAll(){
    return this.http.get<Service[]>(this.url);
  }

  create(service: Service){
    return this.http.post<Service>(this.url, service);
  }
}
