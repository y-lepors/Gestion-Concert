DROP TABLE IF EXISTS Concert;
DROP TABLE IF EXISTS Soiree;
DROP TABLE IF EXISTS Groupe_Has_Artiste;
DROP TABLE IF EXISTS Groupe;
DROP TABLE IF EXISTS Salle;
DROP TABLE IF EXISTS Gestionnaire;
DROP TABLE IF EXISTS Artiste;

CREATE TABLE Artiste (
    idArtiste INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    pseudo VARCHAR(50),
    ville VARCHAR(50),
    age INT
);

CREATE TABLE Gestionnaire (
    idGestionnaire INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    president VARCHAR(50),
    typeGestionnaire ENUM('personne', 'association') 
);

CREATE TABLE Salle (
    idSalle INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    adresse VARCHAR(50),
    capacite INT,
    idGestionnaire INT NOT NULL,
    CONSTRAINT fk_SalleGestionnaire FOREIGN KEY(idGestionnaire) REFERENCES Gestionnaire(idGestionnaire)
);

CREATE TABLE Groupe (
    idGroupe INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50)
);

CREATE TABLE Groupe_Has_Artiste (
    idGroupe INT NOT NULL,
    CONSTRAINT fk_GroupeArtiste FOREIGN KEY(idGroupe) REFERENCES Groupe(idGroupe),
    idArtiste INT NOT NULL,
    CONSTRAINT fk_ArtisteGroupe FOREIGN KEY(idArtiste) REFERENCES Artiste(idArtiste),
    PRIMARY KEY(idGroupe, idArtiste)
);

CREATE TABLE Soiree (
    idSoiree INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    idSalle INT NOT NULL,
    CONSTRAINT fkSoireeSalle FOREIGN KEY(idSalle) REFERENCES Salle(idSalle)
);

CREATE TABLE Concert (
    idConcert INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dateConcert DATETIME,
    duree INT,
    idArtiste INT,
    idGroupe INT,
    idSalle INT NOT NULL,
    idSoiree INT NOT NULL,
    
    CONSTRAINT fkConcertArtiste FOREIGN KEY(idArtiste) REFERENCES Artiste(idArtiste),
    CONSTRAINT fkConcertGroupe FOREIGN KEY(idGroupe) REFERENCES Groupe(idGroupe),
    CONSTRAINT fkConcertSalle FOREIGN KEY(idSalle) REFERENCES Salle(idSalle),
    CONSTRAINT fkConcertSoiree FOREIGN KEY(idSoiree) REFERENCES Soiree(idSoiree)
);