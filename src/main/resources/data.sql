-- Inserimento di alcuni utenti di esempio
INSERT INTO users (username, password, email) VALUES ('user1', 'pass1', 'user1@example.com');
INSERT INTO users (username, password, email) VALUES ('user2', 'pass2', 'user2@example.com');

-- Inserimento di alcune squadre di esempio
INSERT INTO teams (name, budget, user_id) VALUES ('The Gunners', 300, 1);
INSERT INTO teams (name, budget, user_id) VALUES ('The Blues', 300, 2);

-- Inserimento di alcuni giocatori di esempio
INSERT INTO players (name, position, team_name) VALUES ('Player 1', 'Portiere', 'Team A');
INSERT INTO players (name, position, team_name) VALUES ('Player 2', 'Difensore', 'Team A');
INSERT INTO players (name, position, team_name) VALUES ('Player 3', 'Centrocampista', 'Team A');
INSERT INTO players (name, position, team_name) VALUES ('Player 4', 'Attaccante', 'Team A');
INSERT INTO players (name, position, team_name) VALUES ('Player 5', 'Portiere', 'Team B');
INSERT INTO players (name, position, team_name) VALUES ('Player 6', 'Difensore', 'Team B');
INSERT INTO players (name, position, team_name) VALUES ('Player 7', 'Centrocampista', 'Team B');
INSERT INTO players (name, position, team_name) VALUES ('Player 8', 'Attaccante', 'Team B');
