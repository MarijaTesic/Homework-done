--Resenje 1.zadatka
SELECT *
FROM Fakultet
WHERE "Drzavni/Privatni"= "D"

--Resenje 2.zadatka
SELECT *
FROM Fakultet
WHERE "Drzavni/Privatni"="P"

--Resenje 3.zadatka
SELECT COUNT("Drzavni/Privatni")
FROM Fakultet
WHERE "Drzavni/Privatni"="D"

--Resenje 4.zadatka
SELECT AVG(BrojStudenata)
FROM Fakultet

--Resenje 5.zadatka
SELECT AVG(BrojStudenata)
FROM Fakultet
WHERE "Drzavni/Privatni"="D"

--Resenje 6.zadatka
SELECT DISTINCT Grad
FROM Fakultet

--Resenje 7.zadatka
SELECT SUM(BrojStudenata)
FROM Fakultet

--Resenje 8.zadatka
SELECT Ime, Prezime
FROM Student

--Resenje 9.zadatka
SELECT *
FROM Student
WHERE GodinaStudija=3

--Resenje 10.zadatka
SELECT *,MAX(Prosek)
FROM Student

--Resenje 11.zadatka
SELECT *, MAX(Prosek)
FROM Student
WHERE GodinaStudija=3

--Resenje 12.zadatka
SELECT AVG(Prosek)
FROM Student
WHERE GodinaStudija=4

--Resenje 13.zadatka
SELECT AVG(Prosek)
FROM Student
WHERE Pol='M'

--Resenje 14.zadatka
SELECT *
FROM Student
WHERE Prosek IS NULL

--Resenje 15.zadatka
SELECT *
FROM Student
WHERE Prosek IS NOT NULL

--Resenje 16.zadatka
SELECT *
FROM Student
WHERE Prosek>(SELECT AVG(Prosek) FROM Student)


