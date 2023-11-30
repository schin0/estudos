import { Platform } from '@angular/cdk/platform';
import { Component } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-datepicker',
  templateUrl: './datepicker.component.html',
  styleUrls: ['./datepicker.component.scss']
})
export class DatepickerComponent {

  // Com angular:
  // public startDate: Date = new Date();
  // public minDate: Date = new Date(this.startDate.getFullYear(), this.startDate.getMonth() - 1, this.startDate.getDate());
  // public maxDate: Date = new Date(this.startDate.getFullYear(), this.startDate.getMonth() + 1, this.startDate.getDate());
  
  // Com moment.js:
  public startDate = moment();
  public minDate = moment().subtract(1, 'month');
  public maxDate = moment().add(1, 'month');

  constructor(private platform: Platform) { }

  get isTouchDevice() {
    return this.platform.IOS || this.platform.ANDROID;
  }
}
