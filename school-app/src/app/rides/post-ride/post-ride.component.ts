import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RideService } from '../../services/ride.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-ride',
  standalone: true,
  imports: [FormsModule],
  template: `
    <h2>Post a Ride</h2>
    <form (ngSubmit)="onSubmit()">
      <div>
        <label for="startLocation">Start Location:</label>
        <input type="text" id="startLocation" name="startLocation" [(ngModel)]="ride.startLocation" required>
      </div>
      <div>
        <label for="endDestination">End Destination:</label>
        <input type="text" id="endDestination" name="endDestination" [(ngModel)]="ride.endDestination" required>
      </div>
      <div>
        <label for="timeOfDeparture">Time of Departure:</label>
        <input type="datetime-local" id="timeOfDeparture" name="timeOfDeparture" [(ngModel)]="ride.timeOfDeparture" required>
      </div>
      <div>
        <label for="pickupRadius">Pickup Radius (km):</label>
        <input type="number" id="pickupRadius" name="pickupRadius" [(ngModel)]="ride.pickupRadius" required>
      </div>
      <div>
        <label for="seatsAvailable">Seats Available:</label>
        <input type="number" id="seatsAvailable" name="seatsAvailable" [(ngModel)]="ride.seatsAvailable" required>
      </div>
      <div>
        <label for="pricePerSeat">Price per Seat:</label>
        <input type="number" id="pricePerSeat" name="pricePerSeat" [(ngModel)]="ride.pricePerSeat" required>
      </div>
      <div>
        <label for="notes">Notes:</label>
        <textarea id="notes" name="notes" [(ngModel)]="ride.notes"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Post Ride</button>
    </form>
  `,
})
export class PostRideComponent {
  ride: any = {
    startLocation: '',
    endDestination: '',
    timeOfDeparture: '',
    pickupRadius: 0,
    seatsAvailable: 0,
    pricePerSeat: 0,
    notes: '',
    emailid: '' // This should be set from the logged-in user's email
  };

  constructor(private rideService: RideService, private router: Router) {
    // TODO: Get the logged-in user's email and set it to ride.emailid
  }

  onSubmit() {
    this.rideService.postRide(this.ride).subscribe(
      (response) => {
        if (response.success) {
          console.log('Ride posted successfully', response.data);
          this.router.navigate(['/']);
        } else {
          console.error('Failed to post ride', response.message);
        }
      },
      (error) => {
        console.error('Error posting ride', error);
      }
    );
  }
}