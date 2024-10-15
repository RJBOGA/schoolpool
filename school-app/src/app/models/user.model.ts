export interface User {
  id: string;
  name: string;
  email: string;
  role: 'rider' | 'driver';
}