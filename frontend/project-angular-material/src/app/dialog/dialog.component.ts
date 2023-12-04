import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogModalComponent } from './dialog-modal/dialog-modal.component';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent {
  constructor(private dialog: MatDialog) { }

  openDialog() {
    const dialogRef = this.dialog.open(DialogModalComponent, {
      enterAnimationDuration: '5000px',
      exitAnimationDuration: '1000px',
      data: 'Hello World!'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
