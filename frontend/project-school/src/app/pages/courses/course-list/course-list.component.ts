import { Component, OnInit, inject } from '@angular/core';
import { CoursesService } from '@app/services/courses.service';
import { Course } from '@app/shared/models/course';
import { Category } from "./../../../shared/models/category-enum";
import { FormBuilder, FormGroup } from '@angular/forms';

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

  ngOnInit(): void {
    this.getCourses();
    this.validateForm();
  }

  public getCourses(): void {
    this.courseService.get().subscribe((courses: Course[]) => {
      this.courseList = courses;
    });
  }

  public search(): void {

  }

  private validateForm(): void {
    this.form = this.fb.group({
      category: [''],
      search: ['']
    });
  }
}
