import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeProductDetailComponent } from './home-product-detail.component';

describe('HomeProductDetailComponent', () => {
  let component: HomeProductDetailComponent;
  let fixture: ComponentFixture<HomeProductDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeProductDetailComponent]
    });
    fixture = TestBed.createComponent(HomeProductDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
