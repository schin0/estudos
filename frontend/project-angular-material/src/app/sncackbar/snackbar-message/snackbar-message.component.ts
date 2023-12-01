import { Component, Inject } from '@angular/core';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snackbar-message',
  templateUrl: './snackbar-message.component.html',
  styleUrls: ['./snackbar-message.component.scss']
})
export class SnackbarMessageComponent {
  constructor(
    @Inject(MAT_SNACK_BAR_DATA) public data: string,
    public matSnackBarRef : MatSnackBarRef<SnackbarMessageComponent>
  ) { }

    public close() {
      this.matSnackBarRef.dismiss();
    }
}
