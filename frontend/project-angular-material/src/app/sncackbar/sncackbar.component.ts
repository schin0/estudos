import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-sncackbar',
  templateUrl: './sncackbar.component.html',
  styleUrls: ['./sncackbar.component.scss']
})
export class SncackbarComponent {

  constructor(private snackBar: MatSnackBar) { }

  public openSnackbar() {
    const snackbar = this.snackBar.open('Mensagem enviada com sucesso!', 'Fechar', {
      duration: 5000
    });

    snackbar.afterDismissed().subscribe(() => {
      console.log('Snackbar fechado!');
    });

    snackbar.onAction().subscribe(() => {
      console.log('Snackbar fechado pelo botão Fechar!');
    })
  }

}
