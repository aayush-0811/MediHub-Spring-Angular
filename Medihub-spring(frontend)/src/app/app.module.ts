import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DemoAngularMaterailModule } from './DemoAngularMaterialModule';
import { LoginComponent } from './auth/auth-components/login/login.component';
import { SignupComponent } from './auth/auth-components/signup/signup.component';
import { TrackOrderComponent } from './auth/auth-components/track-order/track-order.component';
import { HomeComponent } from './auth/auth-components/home/home.component';
import { HomeProductDetailComponent } from './auth/auth-components/home-product-detail/home-product-detail.component';
import { FooterComponent } from './auth/auth-components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    TrackOrderComponent,
    HomeComponent,
    HomeProductDetailComponent,
    FooterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DemoAngularMaterailModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
