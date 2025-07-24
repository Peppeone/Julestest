CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS leagues (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS teams (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    budget DOUBLE,
    points INTEGER,
    user_id INTEGER,
    league_id INTEGER,
    squad_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (league_id) REFERENCES leagues(id)
);

CREATE TABLE IF NOT EXISTS players (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS squads (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    team_id INTEGER,
    FOREIGN KEY (team_id) REFERENCES teams(id)
);

CREATE TABLE IF NOT EXISTS squad_players (
    squad_id INTEGER,
    player_id INTEGER,
    PRIMARY KEY (squad_id, player_id),
    FOREIGN KEY (squad_id) REFERENCES squads(id),
    FOREIGN KEY (player_id) REFERENCES players(id)
);

CREATE TABLE IF NOT EXISTS match_results (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    team_id INTEGER,
    gameweek INTEGER,
    score INTEGER,
    FOREIGN KEY (team_id) REFERENCES teams(id)
);
