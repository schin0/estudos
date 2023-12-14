import { Category } from "./category-enum";

export interface Course {
    id: number;
    name: string;
    category: Category;
    description: string;
    rating: number;
    year: number;
    professor: string;
    image: string;
}