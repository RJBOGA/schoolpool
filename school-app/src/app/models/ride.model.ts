export interface Ride {
  id: string;
  riderId: string;
  driverId: string;
  pickupLocation: string;
  dropoffLocation: string;
  dateTime: Date;
  status: 'requested' | 'confirmed' | 'completed' | 'cancelled';
}