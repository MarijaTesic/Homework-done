--Resenje 1.zadatka
SELECT Odsek.Naziv, COUNT(SifK) AS "Broj kurseva"
FROM Odsek, Kurs
WHERE Odsek.SifO=Kurs.SifO
GROUP BY Odsek.SifO

--Resenje 2.zadatka
SELECT Kurs.Naziv, COUNT (Pohadja.SifS) AS "Broj Studenata"
FROM Kurs, Pohadja, Raspored
WHERE Raspored.SifR=Pohadja.SifR AND Raspored.SifK=Kurs.SifK
GROUP BY Kurs.SifK
HAVING COUNT (Pohadja.SifS)>3

--Resenje 3.zadatka
SELECT SUM(Raspored.BrPrijaveljenih)/COUNT(DISTINCT Raspored.SifK)
FROM Raspored

--Resenje 4.zadatka 
SELECT Kurs.Naziv
FROM Kurs, Pohadja, Raspored
WHERE Raspored.SifR=Pohadja.SifR AND Raspored.SifK=Kurs.SifK
GROUP BY Kurs.SifK
HAVING Pohadja.SifS=1

--Resenje 5.zadatka
SELECT Student.Ime, COUNT(Pohadja.SifS) AS "Broj predmeta koje pohadja"
FROM Student, Pohadja
WHERE Student.SifS=Pohadja.SifS
GROUP BY Pohadja.SifS
HAVING COUNT(Pohadja.SifS)>2

--Resenje 6.zadatka
SELECT DISTINCT Student.Ime
FROM Student, Ucionica, Pohadja, Raspored
WHERE Pohadja.SifR=Raspored.SifR AND Raspored.SifU=Ucionica.SifU AND Pohadja.SifS=Student.SifS
AND Ucionica.SifU=111 AND Raspored.Dan="Pon"


--Resenje 7.zadatka
SELECT Kurs.Naziv, MAX(BrPrijaveljenih)
FROM Kurs, Raspored
WHERE Raspored.SifK=Kurs.SifK AND Raspored.SifP=7

--Resenje 8.zadatka
SELECT Kurs.Naziv
FROM Preduslov, Kurs
WHERE Preduslov.SifK=4 AND KURS.SifK=Preduslov.SifKP

--Resenje 9.zadatka
SELECT Kurs.Naziv, COUNT (Preduslov.SifKP)
FROM Kurs, Preduslov
WHERE Preduslov.SifK=Kurs.SifK
GROUP BY Kurs.SifK

--Resenje 10.zadatka
SELECT Profesor.Ime, SUM(Raspored.BrPrijaveljenih)
FROM Profesor, Raspored
WHERE Profesor.SifP=Raspored.SifP AND Raspored.Dan="Pon"
GROUP BY Profesor.SifP

