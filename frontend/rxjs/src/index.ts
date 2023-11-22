import { Observable, from } from 'rxjs';

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
})

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

sourceInstance.subscribe(new myObserver());