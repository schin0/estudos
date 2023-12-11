import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { fromEvent, map, distinctUntilChanged } from 'rxjs';
import { BreakpointObserver } from '@angular/cdk/layout';
import { menuItems } from './shared/models/menu';

export const TEXT_LIMIT = 50;
export const SHADOW_LIMIT = 100;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'project-school';

  public isSmallScreen = false;
  public isSidenavOpen = false;
  public popText = false;
  public applyShadow = false;
  public scrollTop = 0;
  public items_menu = menuItems;

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

  ngAfterContentInit(): void {
    this.breakpointObserver.observe(['(max-width: 880px)'])
      .subscribe((res) => this.isSmallScreen = res.matches);
  }

  get sidenavMode() {
    return this.isSmallScreen ? 'over' : 'side';
  }
}
