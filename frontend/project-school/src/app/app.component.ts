import { Component, OnInit, ViewChild, inject } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { fromEvent, map, distinctUntilChanged, filter } from 'rxjs';
import { BreakpointObserver } from '@angular/cdk/layout';
import { menuItems } from './shared/models/menu';
import { NavigationEnd, Router } from '@angular/router';

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
  public menuName = '';

  @ViewChild('sidenav') sidenav: MatSidenav | undefined;

  private breakpointObserver: BreakpointObserver
  private route: Router

  constructor() {
    this.breakpointObserver = inject(BreakpointObserver);
    this.route = inject(Router);
  }

  ngOnInit(): void {
    fromEvent(window, 'scroll')
      .pipe(
        map(() => window.pageYOffset || document.documentElement.scrollTop),
        distinctUntilChanged()
      )
      .subscribe((scrollTop) => {
        this.determineHeader(scrollTop);
      });

    this.route.events.pipe(
      filter((event) => event instanceof NavigationEnd),
      map((event) => event as NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.menuName = this.items_menu.find((item) => item.link === event.url)?.label || '';
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
