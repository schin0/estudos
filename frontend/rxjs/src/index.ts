import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

let numbers = [1, 2, 3];

let sourceInstance = new Observable(subscriber => {
    let i = 0;

    let produceValue = () => {
        subscriber.next(numbers[i++]);

        if (i < numbers.length) {
            setTimeout(produceValue, 500);
            return;
        }

        subscriber.complete();
    };

    produceValue();
    // Pipe chamando depois do subscribe
}).pipe(
    map((n: number) => n + 3)
)

class myObserver {
    next(x: number) {
        console.log(x);
    }

    // Se acionado, para o subscriber
    error(e: Error) {
        console.log(e);
    }

    // Se acionado, para o subscriber
    complete() {
        console.log('Complete');
    }
};

// Pipe chamando antes do subscribe c/ map
sourceInstance.pipe(
    map((n: number) => n + 10)
).subscribe(new myObserver());

// Pipe chamando antes do subscribe c/ filter
sourceInstance.pipe(
    filter((n: number) => n > 2)
).subscribe(new myObserver());