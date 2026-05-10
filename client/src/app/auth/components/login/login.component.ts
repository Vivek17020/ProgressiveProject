import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, of, tap, catchError } from 'rxjs';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  loginError$: Observable<{ [key: string]: string; }> | undefined;
  successMessage: string | null = null;
  errorMessage: string | null = null;
  showPassword: boolean = false;
  isLoading: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.pattern(/^[a-zA-Z0-9]+$/)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.pattern(/^(?=.*[A-Z])(?=.*\d).+$/)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      this.loginError$ = of({
        message: "Please make sure you have filled all the required fields correctly",
      });
      return;
    } else {
      this.isLoading = true;
      this.successMessage = null;
      this.errorMessage = null;

      const { username, password } = this.loginForm.value;
      this.loginError$ = this.authService
        .login({ username, password })
        .pipe(
          tap((response) => {
            console.log(response);

            localStorage.setItem("token", response['token']);
            localStorage.setItem("role", response['role']);
            localStorage.setItem("userId", response['userId']);

            if (response['studentId']) {
              localStorage.setItem("studentId", response['studentId']);
            }
            if (response['teacherId']) {
              localStorage.setItem("teacherId", response['teacherId']);
            }

            console.log(localStorage.getItem("role"));

            this.successMessage = "Login successful! Redirecting...";
            this.isLoading = false;

            const role = this.authService.getRole();
            if (role === 'TEACHER' || role === 'STUDENT') {
              this.router.navigate(['/educonnect']);
            } else {
              this.router.navigate(['/dashboard']);
            }
          }),
          catchError((error) => {
            console.error("Login error:", error);
            this.errorMessage = "Invalid username or password";
            this.isLoading = false;
            return of({ message: "Invalid username or password" });
          })
        );
    }
  }

  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }
}
