create schema tictactoe;
use tictactoe;

create table ergebnis (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
ergebnis VARCHAR(20) NOT NULL
);

create table spieler (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL
);

create table spiel (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
zeit VARCHAR(5) NOT NULL,
spieler_1_id INT NOT NULL,
FOREIGN KEY (spieler_1_id) REFERENCES spieler (id) ON UPDATE CASCADE ON DELETE CASCADE,
spieler_2_id INT NOT NULL,
FOREIGN KEY (spieler_2_id) REFERENCES spieler (id) ON UPDATE CASCADE ON DELETE CASCADE,
ergebnis_id INT NOT NULL,
FOREIGN KEY (ergebnis_id) REFERENCES ergebnis (id) ON UPDATE CASCADE ON DELETE CASCADE
);