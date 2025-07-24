import { User } from './user';
import { Squad } from './squad';
import { League } from './league';

export interface Team {
  id: number;
  name: string;
  points: number;
  user: User;
  squad: Squad;
  league: League;
}
