INSERT INTO Model(Marka, Model, BrProdatih, BrNabavljenih, Profit)
VALUES("BMW", "X6", 10, 20, 10000),
("BMW", "X7", 5, 12, 14000),
("Audi", "A8", 4, 10, 20000),
("Audi", "A4", 6 , 15, 15000),
("Lada", "Niva", 20, 50, 10000),
("Yugo", "Coral 45", 50, 100, 12000);

INSERT INTO Kupac(Ime, Prezime, BrLK, BrKupljenih)
VALUES("Zoran", "Milicevic", 12345678, 2),
("Cvijan", "Peranovic", 12345678, 1),
("Ivana", "Stepanovic", 12345678, 1),
("Dusan", "Bobicic", 12345678, 1);

INSERT INTO Dobavljac(Naziv, BrDobavljenih)
VALUES("YugoMotors", 30),
("SerbiaCarImport", 20),
("BelgradeImport", 10);

INSERT INTO Automobil(RegBr, IdM)
VALUES("123AA", 1), --bmw x6
("123BB", 1),--bmw x6
("123CC", 2),--bmw x7
("123DD", 2),--bmw x7
("123EE", 3),--audi a8
("123FF", 3),--audi a8
("123GG", 4),--audi a4
("123HH", 4),--audi a4
("123JJ", 5),-- lada niva
("123KK", 5),-- lada niva
("123LL", 6),-- yugo
("123MM", 6);-- yugo

INSERT INTO Kupovina(IdA, IdK, DatumVreme, Cena)
VALUES(8, 1, "2018-06-23", 40000),
(6, 1, "2018-04-14", 70000),
(2, 3, "2017-06-15", 25000),
(12, 2, "2015-02-12", 300),
(10, 4, "2016-06-13", 8000);

INSERT INTO Nabavka(IdA, DatumVreme, IdD, Cena)
VALUES(5, "2010-01-01", 3, 30000),
(6, "2010-01-01", 3, 30000),
(7, "2010-01-01", 3, 30000),
(8, "2010-01-01", 3, 30000),
(9, "2000-02-01", 1, 4000),
(10, "2000-02-01", 1, 4000),
(11, "2000-02-01", 1, 4000),
(12, "2000-02-01", 1, 4000),
(1, "2013-01-01", 2, 20000),
(2, "2013-01-01", 2, 20000),
(3, "2013-01-01", 2, 20000),
(4, "2013-01-01", 2, 20000);