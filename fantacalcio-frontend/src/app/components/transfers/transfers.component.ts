import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Player } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-transfers',
  templateUrl: './transfers.component.html',
  styleUrls: ['./transfers.component.css']
})
export class TransfersComponent implements OnInit {

  players: Player[] = [];
  teamId: number;

  constructor(
    private playerService: PlayerService,
    private teamService: TeamService,
    private route: ActivatedRoute
  ) {
    this.teamId = Number(this.route.snapshot.paramMap.get('teamId'));
  }

  ngOnInit(): void {
    this.getPlayers();
  }

  getPlayers(): void {
    this.playerService.getPlayers()
      .subscribe(players => this.players = players);
  }

  addPlayer(playerId: number): void {
    this.teamService.addPlayerToSquad(this.teamId, playerId)
      .subscribe(() => {
        // Optionally, you can refresh the player list or provide user feedback.
      });
  }
}
