import { Component, OnInit } from '@angular/core';
import { Joueur } from '../model/joueur.model';
import { JoueurService } from '../services/joueur.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-joueurs',
  imports: [CommonModule],
  templateUrl: './joueurs.component.html',
  styleUrl: './joueurs.component.css'
})
export class JoueursComponent implements OnInit {

  joueurs!: Joueur[];

  constructor(private joueurService: JoueurService) { }

  ngOnInit(): void {
    this.chargerJoueurs();
  }

  chargerJoueurs() {
    this.joueurService.listeJoueurs().subscribe(joueurs => {
      console.log(joueurs);
      this.joueurs = joueurs;
    });
  }
}