import { Component, OnInit, ViewChild } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { fromEvent } from 'rxjs';
import { distinctUntilChanged, map } from 'rxjs/operators';
import { MatSidenav } from '@angular/material/sidenav';

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
  public isSidenavOpen = false;
  public popText = false;
  public applyShadow = false;
  public scrollTop = 0;

  @ViewChild('sidenav') sidenav: MatSidenav | undefined;

  constructor(private breakpointObserver: BreakpointObserver) { }

  ngOnInit(): void {
    fromEvent(window, 'scroll')
      .pipe(
        map(() => {
          return window.pageYOffset || document.documentElement.scrollTop;
        }),
        distinctUntilChanged()
      )
      .subscribe((scrollTop) => {
        this.determineHeader(scrollTop);
      });
  }

  determineHeader(top: number) {
    this.popText = top > TEXT_LIMIT;
    this.applyShadow = top > SHADOW_LIMIT;
  }

  toggleSidenav() {
    this.isSidenavOpen = !this.isSidenavOpen;
    this.sidenav?.toggle();
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
