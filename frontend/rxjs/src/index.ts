import { from } from 'rxjs';

let numbers = [1, 2, 3];
let source = from(numbers);

function component() {
    source.subscribe({
        next: (x) => console.log(x)
    });
}

component()