DROP TABLE IF EXISTS Automobil;
CREATE TABLE Automobil (
	Id INTEGER  NOT NULL UNIQUE PRIMARY KEY  AUTOINCREMENT, 
	RegBr VARCHAR(255) UNIQUE,
	IdM INTEGER,
	FOREIGN KEY (IdM) REFERENCES Model(Id)
);

DROP TABLE IF EXISTS Model;
CREATE TABLE Model (
	Id INTEGER NOT NULL UNIQUE PRIMARY KEY  AUTOINCREMENT,
	Marka VARCHAR(255),
	Model VARCHAR(255),
	BrProdatih INTEGER,
	BrNabavljenih INTEGER,
	Profit INTEGER
);

DROP TABLE IF EXISTS Kupovina;
CREATE TABLE Kupovina (
	IdA INTEGER PRIMARY KEY,
	IdK INTEGER,
	DatumVreme TEXT,
	Cena INTEGER,
	FOREIGN KEY (IdA) REFERENCES Automobil(Id),
	FOREIGN KEY (IdK) REFERENCES Kupac(Id)
);

DROP TABLE IF EXISTS Kupac;
CREATE TABLE Kupac (
	Id INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT,
	Ime VARCHAR(255) NOT NULL,
	Prezime VARCHAR(255) NOT NULL,
	BrLK INTEGER,
	BrKupljenih INTEGER
);

DROP TABLE IF EXISTS Nabavka;
CREATE TABLE Nabavka (
	IdA INTEGER PRIMARY KEY,
	DatumVreme TEXT,
	IdD INTEGER,
	Cena INTEGER,
	FOREIGN KEY (IdA) REFERENCES Automobil(Id),
	FOREIGN KEY (IdD) REFERENCES Dobavljac(Id)
);

DROP TABLE IF EXISTS Dobavljac;
CREATE TABLE Dobavljac (
	Id INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT,
	Naziv VARCHAR(255) NOT NULL,
	BrDobavljenih INTEGER
)




