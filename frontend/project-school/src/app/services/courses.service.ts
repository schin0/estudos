import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environment } from '@app/environments/environment';
import { Course } from '@app/shared/models/course';
import { Observable, catchError, take, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  coursesUrl = environment.coursesUrl;
  private http = inject(HttpClient);

  public get(currentPage: number, pageSize: number, category: string, search: string): Observable<HttpResponse<any>> {
    let url = `${this.coursesUrl}?_page=${currentPage}&_limit=${pageSize}`

    if (category)
      url += `&q=${category}`;

    if (search)
      url += `&q=${search}`;

    return this.http.get<Course[]>(url, { observe: 'response' })
      .pipe(
        take(1),
        catchError(this.handleError)
      );
  }

  public getById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.coursesUrl}/${id}`)
      .pipe(
        take(1),
        catchError(this.handleError)
      );
  }

  public post(course: Course): Observable<Course> {
    return this.http.post<Course>(this.coursesUrl, course)
      .pipe(
        take(1),
        catchError(this.handleError)
      );
  }

  public put(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.coursesUrl}/${course.id}`, course)
      .pipe(
        take(1),
        catchError(this.handleError)
      );
  }

  public delete(id: number): Observable<Course> {
    return this.http.delete<Course>(`${this.coursesUrl}/${id}`)
      .pipe(
        take(1),
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = '';

    if (error.error instanceof ErrorEvent)
      errorMessage = `Erro frontend: ${error.error.message}`;
    else
      errorMessage = `Erro Backend: ${error.status}, mensagem: ${error.message}`;

    return throwError(() => errorMessage);
  }

}
