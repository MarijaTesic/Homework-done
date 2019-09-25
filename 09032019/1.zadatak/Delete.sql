DELETE FROM Nabavka
WHERE IdA in (SELECT Id FROM Automobil WHERE Idm  in (SELECT Id FROM Model where Model.Model = "X7" AND Model.Marka = "BMW"));

DELETE FROM Automobil
WHERE IdM in (SELECT Id FROM Model WHERE Model.Model = "X7" AND Model.Marka = "BMW");


DELETE FROM Model
WHERE Model.Model = "X7" AND Model.Marka= "BMW";


DELETE FROM Nabavka
WHERE IdA in (SELECT Id FROM Automobil WHERE Id NOT in (SELECT IdA FROM Kupovina));

DELETE FROM Automobil
WHERE Id NOT in (SELECT IdA FROM Kupovina) 