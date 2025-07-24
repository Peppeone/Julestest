import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Squad } from '../models/squad';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private apiUrl = '/api/teams';

  constructor(private http: HttpClient) { }

  addPlayerToSquad(teamId: number, playerId: number): Observable<Squad> {
    return this.http.post<Squad>(`${this.apiUrl}/${teamId}/players`, playerId);
  }
}
