import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from "../service/auth.service";


@Injectable({
  providedIn: 'root'
})
export class ErrorInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthService,
              private router: Router) {
  }

  intercept<T>(request: HttpRequest<T>, next: HttpHandler): Observable<HttpEvent<T>> {
    return next.handle(request).pipe(
      catchError((err: HttpErrorResponse) => {
        if (err.status === 401 || err.status === 403) {
          this.authenticationService.logout();
          this.router.navigate(['']);
        } else if (err.status !== 404) {
          const codeString: string = err.status ? err.status.toString() : '';
          const errorMessage = err.error || err.message || err.statusText || 'An error occurred';
          console.log(codeString + ' - ' + errorMessage);
        }
        return throwError(err);
      })
    );
  }
}
