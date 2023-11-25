import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { pluck, fromEvent } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatToolbar } from '@angular/material/toolbar';

export const SCROLL_CONTAINER = 'mat-sidenav-content';
export const TEXT_LIMIT = 50;
export const SHADOW_LIMIT = 100;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'project-angular-material';
  public isSmallScreen = false;

  constructor(private breakpointObserver: BreakpointObserver) { }

  ngOnInit(): void {
    const container = document.getElementsByClassName(SCROLL_CONTAINER)[0];

    fromEvent(container, 'scroll').subscribe({
      next: (value) => console.log(value)
    })
  }

  // Uso direto
  ngAfterContentInit(): void {
    this.breakpointObserver.observe(['(max-width: 880px)'])
      .subscribe((res) => this.isSmallScreen = res.matches);

  }

  // Uso com operator pluck do rxjs -> analisa se o match existe
  // ngAfterContentInit(): void {
  //   this.breakpointObserver.observe(['(max-width: 880px)'])
  //     .pipe(pluck('matches'))
  //     .subscribe((res: boolean) => this.isSmallScreen = res);
  // }


  get sidenavMode() {
    return this.isSmallScreen ? 'over' : 'side';
  }

}
