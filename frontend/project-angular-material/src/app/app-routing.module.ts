import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FormFieldInputComponent } from './form-field-input/form-field-input.component';
import { ProgressSpinnerComponent } from './progress-spinner/progress-spinner.component';

const routes: Routes = [
  { path: 'formFieldInput', component: FormFieldInputComponent },
  { path: 'progressSpiner', component: ProgressSpinnerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
