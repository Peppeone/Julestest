import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class LeagueService {

  private apiUrl = '/api/leagues';

  constructor(private http: HttpClient) { }

  getStandings(leagueId: number): Observable<Team[]> {
    return this.http.get<Team[]>(`${this.apiUrl}/${leagueId}/standings`);
  }
}
