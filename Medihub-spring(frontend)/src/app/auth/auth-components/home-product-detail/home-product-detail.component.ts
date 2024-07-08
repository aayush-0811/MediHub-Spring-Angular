import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/modules/customer/service/customer.service';

@Component({
  selector: 'app-home-product-detail',
  templateUrl: './home-product-detail.component.html',
  styleUrls: ['./home-product-detail.component.scss']
})
export class HomeProductDetailComponent implements OnInit {
  productId: number;
  isSpinning: boolean = false;
  reviewForm!: FormGroup;
  product: any = {};
  FAQS: any[] = [];
  reviews: any[] = [];

  constructor(
    private snackBar: MatSnackBar,
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute
  ) {
    this.productId = this.activatedRoute.snapshot.params["productId"];
  }

  ngOnInit(): void {
    this.getHomeProductDetailById();
  }

  getHomeProductDetailById() {
    this.customerService.getHomeProductDetailById(this.productId).subscribe(
      (res) => {
        console.log(res);
        this.product = res.productDto || {};
        if (this.product.returnedImg != null) {
          this.product.processedImg = 'data:image/png;base64,' + this.product.returnedImg;
        }
        this.FAQS = res.faqDtoList || [];
        this.reviews = [];
        (res.reviewDtoList || []).forEach(element => {
          if (element.returnedImg) {
            element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
          }
          this.reviews.push(element);
        });
      },
      (error) => {
        console.error('Error fetching product details', error);
        this.snackBar.open('Failed to load product details', 'Close', {
          duration: 5000
        });
      }
    );
  }
}
