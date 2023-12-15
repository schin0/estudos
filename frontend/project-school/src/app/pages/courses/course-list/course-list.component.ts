import { Component, OnInit, inject } from '@angular/core';
import { CoursesService } from '@app/services/courses.service';
import { Course } from '@app/shared/models/course';
import { Category } from "./../../../shared/models/category-enum";
import { FormBuilder, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { HttpResponse } from '@angular/common/http';
import { debounceTime } from 'rxjs';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss'],
})
export class CourseListComponent implements OnInit {
  public courseList: Course[] = [];
  public courseService = inject(CoursesService);
  public categoryList: string[] = Object.values(Category) as string[];
  private fb = inject(FormBuilder);
  public form!: FormGroup;

  totalCount: number = 0;
  currentPage: number = 0;
  pageSize: number = 5;

  get f(): any {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.validateForm();
    this.form.valueChanges
      .pipe(debounceTime(500))
      .subscribe((value) => {
        if (value)
          this.search();
      });
    this.getCourses(1, 5, '', '');
  }

  public getCourses(currentPage: number, pageSize: number, category: string, search: string): void {
    this.courseService.get(currentPage, pageSize, category, search)
      .subscribe((response: HttpResponse<any>) => {
        this.courseList = response.body as Course[];
        let totalCount = response.headers.get('X-Total-Count');
        this.totalCount = totalCount ? Number(totalCount) : 0;
      });
  }

  public search(): void {
    this.getCourses(this.currentPage, this.pageSize, this.f.category.value ?? '', this.f.search.value ?? '');
  }

  public handlePageEvent(event: PageEvent): void {
    this.currentPage = event.pageIndex + 1;
    this.pageSize = event.pageSize;

    this.search();
  }

  private validateForm(): void {
    this.form = this.fb.group({
      category: [''],
      search: ['']
    });
  }
}
