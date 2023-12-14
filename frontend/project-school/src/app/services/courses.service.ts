import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environment } from '@app/environments/environment';
import { Course } from '@app/shared/models/course';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  coursesUrl = environment.coursesUrl;
  private http = inject(HttpClient);

  public get(): Observable<Course[]> {
    return this.http.get<Course[]>(this.coursesUrl);
  }
  
  public getById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.coursesUrl}/${id}`);
  }

  public post(course: Course): Observable<Course> {
    return this.http.post<Course>(this.coursesUrl, course);
  }

  public put(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.coursesUrl}/${course.id}`, course);
  }

  public delete(id: number): Observable<Course> {
    return this.http.delete<Course>(`${this.coursesUrl}/${id}`);
  }

}
