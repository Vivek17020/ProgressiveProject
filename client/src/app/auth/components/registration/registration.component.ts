import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent {

    registrationForm!: FormGroup;
    successMessage: string | null = null;
    errorMessage: string | null = null;
    selectedRole: string | null = null;

    registeredUser: any = null; // ✅ FIX ADDED

    constructor(private formBuilder: FormBuilder, private authService: AuthService) { }

    ngOnInit(): void {
        this.registrationForm = this.formBuilder.group({
            username: ['', [
                Validators.required,
                Validators.pattern(/^[a-zA-Z0-9]+$/),
                Validators.minLength(3)
            ]],
            email: ['', [Validators.required, Validators.email]],
            password: ['', [
                Validators.required,
                Validators.minLength(8),
                Validators.pattern(/^(?=.*[A-Z])(?=.*\d).+$/)
            ]],
            role: ['', [Validators.required]],
            fullName: ['', Validators.required],
            contactNumber: ['', [
                Validators.required,
                Validators.pattern(/^[0-9]{10}$/) // ✅ 10 digit validation
            ]],
            subject: [''],
            yearsOfExperience: [null],
            dateOfBirth: [null],
            address: [''],
        });
    }

    onRoleChange(event: Event): void {
        const role = (event.target as HTMLSelectElement).value;
        this.selectedRole = role;

        if (role === 'TEACHER') {
            this.registrationForm.patchValue({
                dateOfBirth: null,
                address: ''
            });
        } else if (role === 'STUDENT') {
            this.registrationForm.patchValue({
                subject: '',
                yearsOfExperience: null
            });
        }
    }

    onSubmit(): void {
        if (this.registrationForm.valid) {

            const formData = this.registrationForm.value;

            this.authService.createUser(formData).subscribe({
                next: (response) => {
                    this.successMessage = "User successfully registered ✅";
                    this.errorMessage = null;

                    this.registeredUser = formData; // ✅ FIX ADDED

                    console.log('Success:', response);

                    this.resetForm();
                },
                error: (error: HttpErrorResponse) => {
                    if (error.error) {
                        this.errorMessage = error.error;
                    } else {
                        this.errorMessage = 'Something went wrong. Please try again.';
                    }

                    this.successMessage = null;
                    console.error('Error:', this.errorMessage);
                }
            });

        } else {
            this.errorMessage = 'Please fill all fields correctly ❌';
            this.successMessage = null;
        }
    }

    resetForm(): void {
        this.registrationForm.reset();
        this.selectedRole = null; // ✅ reset role UI as well
    }
}