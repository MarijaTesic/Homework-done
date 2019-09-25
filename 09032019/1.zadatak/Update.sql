UPDATE Kupovina
SET Cena = 25000
WHERE IdK in (SELECT Id FROM Kupac WHERE Ime = "Zoran") 
AND IdA in (SELECT Id FROM Automobil where IdM in (SELECT Id FROM Model WHERE Model.Marka = "Audi" AND Model.Model = "A4"));

UPDATE Nabavka
SET Cena = Cena*1.10
WHERE IdA in (SELECT Id FROM Automobil WHERE IdM in (SELECT Id FROM Model WHERE Marka = "Audi" AND Model = "A8" OR Model = "A4"))