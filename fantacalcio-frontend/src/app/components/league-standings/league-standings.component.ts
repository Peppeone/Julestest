import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Team } from 'src/app/models/team';
import { LeagueService } from 'src/app/services/league.service';

@Component({
  selector: 'app-league-standings',
  templateUrl: './league-standings.component.html',
  styleUrls: ['./league-standings.component.css']
})
export class LeagueStandingsComponent implements OnInit {

  standings: Team[] = [];
  leagueId: number;

  constructor(
    private leagueService: LeagueService,
    private route: ActivatedRoute
  ) {
    this.leagueId = Number(this.route.snapshot.paramMap.get('leagueId'));
  }

  ngOnInit(): void {
    this.getStandings();
  }

  getStandings(): void {
    this.leagueService.getStandings(this.leagueId)
      .subscribe(standings => this.standings = standings);
  }
}
