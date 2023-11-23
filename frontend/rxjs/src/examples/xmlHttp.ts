import { Observable, fromEvent } from 'rxjs';
import { switchMap, retry, retryWhen, scan, delay, takeWhile } from 'rxjs/operators';

interface ITeam {
    name: string;
}

interface IRetry {
    attempt: number;
    timeDelay: number;
}

let output = document.getElementById('output');
let click = fromEvent(document.getElementById('button'), 'click');

function load(url: string): Observable<any> {
    return new Observable((subscriber) => {
        let xhr = new XMLHttpRequest();
        output.innerHTML = '';

        xhr.addEventListener('load', () => {
            if (xhr.status == 200) {
                let data = JSON.parse(xhr.responseText);

                subscriber.next(data);
                subscriber.complete();
                return;
            }

            subscriber.error(xhr.statusText);
        });

        xhr.open('GET', url);
        xhr.send();
    }).pipe(
        // retry(3)
        // retryWhen(retryStrategy({ attempt: 3, timeDelay: 1000 })) // ---> Deprecated
        retry({ count: 3, delay: 500 })
    );
}

function retryStrategy(retryParams: IRetry) {
    return (errors: Observable<any>) => {
        return errors.pipe(
            scan((acc, value) => {
                return acc + 1;
            }, 0),
            takeWhile(acc => acc < retryParams.attempt),
            delay(retryParams.timeDelay)
        );
    };
}

function renderTeams(teams: ITeam[]) {
    teams.forEach((team: ITeam) => {
        let div = document.createElement('div');
        div.innerText = team.name;

        output.appendChild(div);
    });
}

click.pipe(
    // switchMap(() => load('../teaams.json')) // Error
    switchMap(() => load('../teams.json')) // URL from index.ts
).subscribe({
    next: renderTeams,
    error: (e: Error) => console.log(`Error: ${e}`),
    complete: () => console.log('Completed')
})