import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-request-ride',
  standalone: true,
  imports: [FormsModule],
  template: `
    <h2>Request a Ride</h2>
    <form (ngSubmit)="onSubmit()">
      <div>
        <label for="startLocation">Start Location:</label>
        <input type="text" id="startLocation" name="startLocation" [(ngModel)]="rideRequest.startLocation" required>
      </div>
      <div>
        <label for="endDestination">End Destination:</label>
        <input type="text" id="endDestination" name="endDestination" [(ngModel)]="rideRequest.endDestination" required>
      </div>
      <div>
        <label for="timeOfDeparture">Preferred Time of Departure:</label>
        <input type="datetime-local" id="timeOfDeparture" name="timeOfDeparture" [(ngModel)]="rideRequest.timeOfDeparture" required>
      </div>
      <div>
        <label for="numberOfSeats">Number of Seats:</label>
        <input type="number" id="numberOfSeats" name="numberOfSeats" [(ngModel)]="rideRequest.numberOfSeats" required>
      </div>
      <div>
        <label for="notes">Additional Notes:</label>
        <textarea id="notes" name="notes" [(ngModel)]="rideRequest.notes"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Request Ride</button>
    </form>
  `,
})
export class RequestRideComponent {
  rideRequest = {
    startLocation: '',
    endDestination: '',
    timeOfDeparture: '',
    numberOfSeats: 1,
    notes: ''
  };

  onSubmit() {
    // TODO: Implement request ride logic
    console.log('Ride requested', this.rideRequest);
  }
}