--Resenje 1. zadatka
SELECT *
FROM predmet

--Resenje 2. zadatka
SELECT *
FROM dosije
where dosije.mesto_rodjenja = "Beograd"

--Resenje 3. zadatka
SELECT DISTINCT mesto_rodjenja
FROM dosije
WHERE mesto_rodjenja IS NOT NULL

--Resenje 4. zadatka
SELECT naziv
FROM predmet
WHERE bodovi > 6

--Resenje 5. zadatka
SELECT sifra, naziv
FROM predmet
WHERE bodovi BETWEEN 8 AND 15

--Resenje 6. zadatka
SELECT  *
FROM  ispit
WHERE    bodovi = 81 OR bodovi = 76 OR bodovi = 59
GROUP BY id_predmeta

--Resenje 7. zadatka
SELECT  *
FROM  ispit
WHERE    bodovi IS NOT 81 AND bodovi  IS NOT 76 AND bodovi IS NOT  59
GROUP BY id_predmeta

--Resenje 8. zadatka
SELECT predmet.naziv, 1500*bodovi AS "Cena za samofin"
FROM predmet

--Resenje 9. zadatka
SELECT predmet.naziv, "Cena u dinarima" AS "Cena u Dinarima", 1500*bodovi AS "Cena za samofin"
FROM predmet

--Resenje 10. zadatka
--a:
SELECT *
FROM predmet
ORDER BY bodovi ASC
--b:
SELECT *
FROM predmet
ORDER BY bodovi DESC
--c:
SELECT *
FROM predmet
ORDER BY bodovi ASC, naziv DESC
--Resenje 11. zadatka(ovo ne moze izgleda bez menjanja polja u format yyyy-mm-dd)
SELECT ime, prezime, datum_rodjenja
FROM dosije
WHERE datum_rodjenja BETWEEN '1995-02-04' AND '1995-10-10'

--Resenje 12. zadatka(greska)
SELECT ispitni_rok.oznaka_roka, count(DISTINCT ispit.id_predmeta) AS "Broj polozenih ispita", count(DISTINCT ispit.indeks)
FROM ispitni_rok, ispit, dosije
WHERE ispit.bodovi IS NOT NULL AND ispit.ocena >5 AND ispitni_rok.godina_roka = 2015  AND dosije.indeks = ispit.indeks
GROUP BY ispitni_rok.oznaka_roka
--Resenje 13. zadatka

SELECT  dosije.ime,  dosije.prezime
FROM dosije, predmet,ispitni_rok, ispit
WHERE  ispit.id_predmeta = 1001 AND ispit.godina_roka = 2015 AND ispit.oznaka_roka = "jan" AND ispit.ocena > 5 AND ispit.indeks = dosije.indeks 
GROUP by dosije.indeks

--Resenje 14. zadatka
SELECT ispit.oznaka_roka, AVG(ispit.bodovi)
FROM ispit
WHERE ispit.id_predmeta = 1021 AND ispit.godina_roka = 2015 AND ispit.oznaka_roka != "apr" AND ispit.bodovi IS NOT NULL -- ne znam da li treba da se ignorisu ovi null ili ne, ako ne onda je resenje jan/feb null
GROUP BY ispit.oznaka_roka

--Resenje 15. zadatka
SELECT COUNT(DISTINCT ispit.indeks)
FROM dosije, ispit
WHERE ispit.indeks = dosije.indeks AND ispit.ocena > 5  

--Resenje 16. zadatka
SELECT AVG(ispit.bodovi)
FROM ispit
WHERE ispit.indeks = 20130023 AND ispit.bodovi IS NOT NULL

--Resenje 17. zadatka
SELECT AVG(ispit.ocena)
FROM ispit
WHERE ispit.oznaka_roka = "jan"

--Resenje 18. zadatka
SELECT DISTINCT predmet.naziv
FROM predmet, ispit
WHERE predmet.bodovi = 6 AND ispit.oznaka_roka = "jan" AND ispit.godina_roka = 2015 AND predmet.id_predmeta = ispit.id_predmeta
