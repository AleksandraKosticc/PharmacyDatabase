use apoteka;

-- -----------------------
-- MJESTO
-- -----------------------
insert into mjesto values ('78000', 'Banja Luka'), ('71000', 'Sarajevo');

-- -----------------------
-- BANKA
-- -----------------------
insert into banka (IdBanke, Naziv, Adresa, BrojPoste) values (1, 'Nova banka', 'Kralja Alfonsa XIII 37a', '78000');
insert into banka (IdBanke, Naziv, Adresa, BrojPoste) values (2, 'Razvojna banka', 'Milana Tepića 4', '78000');

-- -----------------------
-- PROIZVODJAC
-- -----------------------
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (1,'Hemofarm','Novakovići бб','051/331‐650','78000');
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (2,'Bosnalijek','Jukićeva б3','033/254-400','71000');
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (3, 'Krka','Džemala Bijedića 125a','033/720-550','71000');
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (4, 'Nobel','Hasiba Brankovića 9','033/770-633','71000');
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (5, 'Prizma','Braće Mažar i majke Marije 18','051/212-377','78000');
insert into proizvodjac (IdProizvodjac, Naziv, Adresa, Telefon, BrojPoste) values (6, 'Alma Derm','Sarači 9','062/004-604','71000');

-- -----------------------
-- APOTEKA
-- -----------------------
insert into apoteka (IdApoteke, NazivApoteke, Adresa, Email, BrojPoste) values
(1, 'Apoteka', 'Stepe Stepanovica', 'apoteka@gmail.com', '78000');

-- -----------------------
-- TELEFON_APOTEKE
-- -----------------------
insert into telefon_apoteke (Telefon, IdApoteke) values ('051/111-222', 1), ('051/111-223', 1);

-- -----------------------
-- ZAPOSLENI
-- -----------------------
insert into zaposleni (IdZaposlenog, KorisnickoIme, Lozinka, Ime, Prezime, JMBG, Email, DatumZaposlenja, Plata, AdresaStanovanja, RadnoVrijeme, BrojPoste, IdApoteke) values
(1, 'marko', 'marko', 'Marko', 'Marković', '0101980100007', 'markom@gmail.com', '2020-08-03', '1400', 'Stepe Stepanovica 64', '8 sati' , '78000', 1);
insert into zaposleni (IdZaposlenog, KorisnickoIme, Lozinka, Ime, Prezime, JMBG, Email, DatumZaposlenja, Plata, AdresaStanovanja, RadnoVrijeme, BrojPoste, IdApoteke) values
(2, 'milan', 'milan', 'Milan', 'Milanović', '0512983100067', 'milanm@gmail.com', '2020-08-03','1200', 'Majke Knezopoljke 3', '8 sati', '78000', 1);
insert into zaposleni (IdZaposlenog, KorisnickoIme, Lozinka, Ime, Prezime, JMBG, Email, DatumZaposlenja, Plata, AdresaStanovanja, RadnoVrijeme, BrojPoste, IdApoteke) values
(3, 'ana', 'ana', 'Ana', 'Ivanović', '0308983126116', 'anai@gmail.com', '2020-08-04', '1200', 'Jug Bogdana 8', '8 sati' , '78000', 1);


insert into magistar_farmacije (BrojLicence, RokVazenja, IdZaposlenog) values ('1234-56/15','2021-01-10',1);

insert into farmaceutski_tehnicar(IdZaposlenog) values (2);
insert into farmaceutski_tehnicar(IdZaposlenog) values (3);

- -----------------------
-- ARTIKLI
-- -----------------------
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1111', 'Aspirin',  2000, '1');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1112', 'Ulosan', 1000, '2');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1113', 'Ultop', 500, '3');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1114', 'Brufen', 200, '4');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1115', 'Brufen', 1500, '1');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1116', 'Paracetamol', 1000, '2');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1117', 'Paracetamol', 1000, '3');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1118', 'Aparat za šećer', 10, '5');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1119', 'Mjerač krvnog pritiska', 15, '5');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1120', 'Toplomjer', 6, '5');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1121', 'Inhalator', 5, '5');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1122', 'Zaštita od sunca SPF 50+', 100, '6');
insert into artikal(Barkod, NazivArtikla, Zaliha, IdProizvodjac) values
('1123', 'Zaštita od sunca SPF 50+', 150, '6');


-- -----------------------
-- TIP_ARTIKLA
-- -----------------------
insert into tip_artikla (IdTipArtikla, NazivTipa) values (1, 'Izdaje se na recept'), (2, 'Izdaje se bez recepta'), (3, 'Ostalo');

-- -----------------------
-- ARTIKAL_TIP_ARTIKLA
-- -----------------------
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1111, 2);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1112, 1);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1113, 1);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1114, 2);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1115, 2);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1116, 2);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1117, 2);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1118, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1119, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1120, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1121, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1122, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1123, 3);
insert into artikal_tip_artikla(Barkod, IdTipArtikla) values (1111, 1);

-- -----------------------
-- CIJENA
-- -----------------------

insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(1, 2.85, '3', '2020-08-08 15:29:40', null, 1111, 1);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(2, 4, 5.34,'2020-08-08 15:29:45', null, 1112, 1);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(3, 4.23, '5.24', '2020-08-08 15:29:47', null, 1113, 1);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(4, 1.56, '2.20', '2020-08-08 15:29:48', null, 1114, 2);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(5, 1.23,'2.35', '2020-08-08 15:30:01', null, 1115, 2);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(6, 0.83, '1.58', '2020-08-08 15:31:10', null, 1116, 2);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(7, 0.90, '1.78', '2020-08-08 15:32:20', null, 1117, 2);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(8, 21, '30', '2020-08-08 15:33:20', null, 1118, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(9, 83.50, '96.35','2020-08-08 15:34:26', null, 1119, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(10, 11.05, '13','2020-08-08 15:35:35', null, 1120, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(11, 120, '150', '2020-08-08 15:36:45', null, 1121, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(12, 25, '32.50', '2020-08-08 15:37:50', null, 1122, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(13, 20, '23.50', '2020-08-08 15:38:20', null, 1123, 3);
insert into cijena (IdCijena, NabavnaCijena, ProdajnaCijena, DatumOd, DatumDo, Barkod, IdTipArtikla) values
(14, 2.85, '4.5', '2020-08-08 15:29:39', null, 1111, 2);

-- -----------------------
-- LIJEK
-- -----------------------
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('acetilsalicilna kiselina', '500 mg', 'obložena tableta','A', 1111);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('omeprazol', '20 mg', 'kapsule', 'B', 1112);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('omeprazol', '20 mg', 'kapsule', 'B', 1113);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('ibuprofen', '400 mg', 'film tablete', 'A', 1114);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('ibuprofen', '400 mg', 'film tablete', 'A', 1115);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('paracetamol', '100 ml', 'sirup','A', 1116);
insert into lijek (GenerickiNaziv, Doza, Oblik, NazivListe, Barkod) values
('paracetamol', '100 ml', 'sirup', 'A', 1117);

-- -----------------------
-- MEDICINSKI APARATI
-- -----------------------
insert into medicinski_aparat(Barkod) values (1118), (1119), (1120), (1121);

-- -----------------------
-- KOZMETIKA
-- -----------------------
insert into kozmetika(JedinicaMjere, Barkod) values ('50 ml', 1122), ('30 ml', 1123);


-- -----------------------
-- RACUN_U_BANCI
-- -----------------------
insert into racun_u_banci (BrojRacuna, IdBanke) values ('1111222233334444', 1), ('1111111111111111', 2), ('2222222222222222', 1), ('3333333333333333', 1), ('4444444444444444', 1), ('5555555555555555', 1), ('6666666666666666', 1);

-- -----------------------
-- RACUN_APOTEKA
-- -----------------------
insert into racun_apoteka (IdApoteke, BrojRacuna, Stanje) values (1, '1111222233334444',100250);

