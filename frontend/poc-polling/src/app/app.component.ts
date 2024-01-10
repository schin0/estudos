import { Component, OnDestroy, OnInit } from '@angular/core';
import { MonoTypeOperatorFunction, Observable, Subscription, combineLatest, filter, finalize, interval, last, map, of, scan, startWith, switchMap, switchMapTo, take, takeWhile, tap, timer } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'poc-polling';

  timeInterval: Subscription | undefined;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    const tempoIntervalo = 2000;
    const tempoMaximoPolling = 5000;
    const numeroMaximoTentativas = this.calcularNumeroMaximoTentativas(tempoIntervalo, tempoMaximoPolling);

    const res1$ = this.getPosts().pipe(
      this.poolingEnquanto(
        tempoIntervalo,
        (response: any) => this.verificarCondicaoParaContinuar(response),
        numeroMaximoTentativas,
        () => {
          this.callbackQuandoCondicaoSatisfeita();
        })
    );

    res1$.subscribe((response: any) => console.log(response));
  }

  calcularNumeroMaximoTentativas(tempoIntervalo: number, tempoMaximoPolling: number) {
    return Math.round(tempoMaximoPolling / tempoIntervalo);
  }

  verificarCondicaoParaContinuar(retorno: any) {
    return retorno.body[3].id != 3;
  }

  callbackQuandoCondicaoSatisfeita() {
    console.log("A condição foi satisfeita!");
  }

  verificarTentativas(numeroMaximoTentativas: number) {
    return (contagem: number) => {
      if (contagem > numeroMaximoTentativas)
        throw new Error("Número máximo de tentativas atingido!");
    };
  }

  poolingEnquanto<T>(
    tempoIntervalo: number,
    condicaoParaContinuar: (retorno: T) => boolean,
    numeroMaximoTentativas: number = 10,
    callbackCondicaoSatisfeita: () => void
  ): MonoTypeOperatorFunction<T> {
    return source$ => {
      return timer(0, tempoIntervalo).pipe(
        scan(tentativas => ++tentativas, 0),
        tap(this.verificarTentativas(numeroMaximoTentativas)),
        switchMap(() => source$),
        takeWhile(condicaoParaContinuar, true),
        finalize(() => callbackCondicaoSatisfeita())
      );
    };
  }

  ngOnDestroy(): void {
    this.timeInterval?.unsubscribe();
  }

  getPosts() {
    return this.http.get('https://jsonplaceholder.typicode.com/posts', { observe: 'response' });
  }



}
