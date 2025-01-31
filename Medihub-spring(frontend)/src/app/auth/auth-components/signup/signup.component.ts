import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, ValidatorFn } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../../auth-services/auth-service/auth.service';

// Custom validator function to check if the input contains only alphabetic characters
function alphaOnlyValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const regex = /^[a-zA-Z\s]*$/; // Regex to allow only alphabets and spaces
    if (regex.test(control.value)) {
      return null; // Valid input
    } else {
      return { 'invalidName': true }; // Invalid input
    }
  };
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  signupForm!: FormGroup;
  isSpinning = false;
  hidePassword = true;

  constructor(
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      name: [null, [Validators.required, alphaOnlyValidator()]], // Include custom validator here
      email: [null, [Validators.email, Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]],
    });
  }

  togglePasswordVisibility() {
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(): void {
    if (this.signupForm.valid) {
      const password = this.signupForm.get('password')?.value;
      const confirmPassword = this.signupForm.get('confirmPassword')?.value;

      if (password !== confirmPassword) {
        this.snackBar.open('Passwords do not match.', 'Close', { duration: 5000, panelClass: 'error-snackbar' });
        return;
      }

      this.isSpinning = true;

      // Perform the signup logic here
      this.authService.register(this.signupForm.value).subscribe(
        (response) => {
          this.isSpinning = false;
          console.log(response);
          this.snackBar.open('Sign up successful!', 'Close', { duration: 5000 });
          // Navigate to the login page or perform any other action
          this.router.navigateByUrl("/login");
        },
        (error) => {
          this.isSpinning = false;
          this.snackBar.open('Sign up failed. Please try again.', 'Close', { duration: 5000, panelClass: 'error-snackbar' });
        }
      );
    } else {
      // Mark all fields as touched to display validation messages
      Object.values(this.signupForm.controls).forEach(control => {
        control.markAsTouched();
      });
    }
  }
}
