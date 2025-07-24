-- Inserimento di alcuni utenti di esempio
INSERT INTO users (username, password, email) VALUES ('user1', 'pass1', 'user1@example.com');
INSERT INTO users (username, password, email) VALUES ('user2', 'pass2', 'user2@example.com');

-- Inserimento di alcune leghe di esempio
INSERT INTO leagues (name) VALUES ('Serie A');
INSERT INTO leagues (name) VALUES ('Premier League');

-- Inserimento di alcune squadre di esempio
INSERT INTO teams (name, budget, user_id, league_id) VALUES ('The Gunners', 300, 1, 1);
INSERT INTO teams (name, budget, user_id, league_id) VALUES ('The Blues', 300, 2, 1);

-- Inserimento di alcuni giocatori di esempio
INSERT INTO players (name, position, price) VALUES ('Player 1', 'Portiere', 10);
INSERT INTO players (name, position, price) VALUES ('Player 2', 'Difensore', 20);
INSERT INTO players (name, position, price) VALUES ('Player 3', 'Centrocampista', 30);
INSERT INTO players (name, position, price) VALUES ('Player 4', 'Attaccante', 40);
INSERT INTO players (name, position, price) VALUES ('Player 5', 'Portiere', 12);
INSERT INTO players (name, position, price) VALUES ('Player 6', 'Difensore', 22);
INSERT INTO players (name, position, price) VALUES ('Player 7', 'Centrocampista', 32);
INSERT INTO players (name, position, price) VALUES ('Player 8', 'Attaccante', 42);
