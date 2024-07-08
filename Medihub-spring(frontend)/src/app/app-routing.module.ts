import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/auth-components/login/login.component';
import { SignupComponent } from './auth/auth-components/signup/signup.component';
import { NoAuthGuard } from './auth/auth-guards/noAuth/no-auth.guard';
import { TrackOrderComponent } from './auth/auth-components/track-order/track-order.component';
import { HomeComponent } from './auth/auth-components/home/home.component';
import { HomeProductDetailComponent } from './auth/auth-components/home-product-detail/home-product-detail.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [NoAuthGuard] },

  { path: 'register', component: SignupComponent, canActivate: [NoAuthGuard] },
  { path: 'login', component: LoginComponent, canActivate: [NoAuthGuard] },
  { path: 'order', component: TrackOrderComponent, canActivate: [NoAuthGuard] },
  { path: 'admin', loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule) },
  { path: 'customer', loadChildren: () => import('./modules/customer/customer.module').then(m => m.CustomerModule) },
  { path: 'product/:productId', component: HomeProductDetailComponent, canActivate: [NoAuthGuard] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
