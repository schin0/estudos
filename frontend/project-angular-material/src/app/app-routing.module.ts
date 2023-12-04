import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FormFieldInputComponent } from './form-field-input/form-field-input.component';
import { ProgressSpinnerComponent } from './progress-spinner/progress-spinner.component';
import { TabsComponent } from './tabs/tabs.component';
import { DatepickerComponent } from './datepicker/datepicker.component';
import { SncackbarComponent } from './sncackbar/sncackbar.component';
import { DialogComponent } from './dialog/dialog.component';

const routes: Routes = [
  { path: 'formFieldInput', component: FormFieldInputComponent },
  { path: 'progressSpiner', component: ProgressSpinnerComponent },
  { path: 'tabs', component: TabsComponent },
  { path: 'datepicker', component: DatepickerComponent },
  { path: 'snackbar', component: SncackbarComponent },
  { path: 'dialog', component: DialogComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
