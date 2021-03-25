import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { AirportService } from './service/airport.service';
import { UserService } from './service/user.service';

@NgModule({
  declarations: [
    AppComponent,
    AirportListComponent,
    UserListComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AirportService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }