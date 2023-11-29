import { Component, OnInit, ViewChild } from '@angular/core';
import { MatProgressBar } from '@angular/material/progress-bar';
import { delay, interval, map, of, takeWhile } from 'rxjs';

interface optionsLoading {
  speed: number;
  delay?: number;
  alterMode?: boolean;
}

@Component({
  selector: 'app-progress-spinner',
  templateUrl: './progress-spinner.component.html',
  styleUrls: ['./progress-spinner.component.scss']
})
export class ProgressSpinnerComponent implements OnInit {
  public loadingPercent: number = 0;
  public loadingPercentQuery: number = 0;

  @ViewChild('progress') progress: MatProgressBar | undefined;

  ngOnInit(): void {
    this.loadingProgress({ speed: 500 }).subscribe(
      (value: number) => {
        this.loadingPercent = value;
      }
    );

    this.loadingProgress({ delay: 2000, speed: 100, alterMode: true }).subscribe(
      (value: number) => {
        this.loadingPercentQuery = value;
      }
    );
  }

  loadingProgress(options: optionsLoading) {
    return interval(options.speed)
      .pipe(
        delay(options.delay || 0),
        map((i) => {
          if (options.alterMode)
            if (this.progress)
              this.progress.mode = 'determinate';

          return i * 5;
        }
        ),
        takeWhile(i => i <= 100)
      )
  }

}
