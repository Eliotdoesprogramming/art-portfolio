import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import {Image} from '../image';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  @Input() image:Image;
  constructor() { }

  ngOnInit(): void {
  }

}
