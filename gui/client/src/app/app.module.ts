import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { AirportService } from './service/airport.service';

@NgModule({
  declarations: [
    AppComponent,
    AirportListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AirportService],
  bootstrap: [AppComponent]
})
export class AppModule { }