INSERT INTO admins (id, email,password) VALUES (999, 'admin@gmail.com','admin');

INSERT INTO bmi (id, tezina,visina,godine,status, score) VALUES (5,123,123,123,1, 0);
INSERT INTO krvni_pritisak(id, gornji_pritisak,donji_pritisak,status) VALUES (8,100,100,1);

INSERT INTO clients (id, email, password, bmi_id, kp_id) VALUES (2,'client@gmail.com', 'client', 5,8);

INSERT INTO notifications(id, text, user_id) VALUES (3,'hello',2);


INSERT INTO individualni_sport(id,ime, brzina, cena, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (51,"individualni", 50, 1, 50, 50,50,50, 3, 2);
INSERT INTO timski_sport(id,ime, brzina, cena, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (51,"timski", 50, 1, 50, 50,50,50, 3, 2);
INSERT INTO ekstremni_sport(id,ime, brzina, cena, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (51,"ekstremni", 50, 1, 50, 50,50,50, 3, 2);

INSERT INTO individualna_kategorija(id,podkategorija, ind_sport_id) VALUES (21,1,51);
INSERT INTO timska_kategorija(id,podkategorija, tim_sport_id) VALUES (21,1,51);
INSERT INTO ekstremna_kategorija(id,podkategorija, ekst_sport_id) VALUES (21,1,51);
