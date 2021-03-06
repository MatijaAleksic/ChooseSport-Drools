INSERT INTO bmi (tezina,visina,godine,status, score) VALUES (75,184,24,1, 0);
INSERT INTO krvni_pritisak(gornji_pritisak,donji_pritisak,status) VALUES (100,100,2);

INSERT INTO clients (id, email, password, bmi_id, kp_id, chosen_sport_id, last_bmi_check, last_satisfaction_check) VALUES (9999, 'client@gmail.com', 'client', 1,1, null, null, null);
INSERT INTO admins (id, email,password) VALUES (9998, 'admin@gmail.com','admin');

INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-18 13:51:00', 'text1',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-18 13:52:00', 'text2',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-18 13:53:00', 'text3',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-18 19:54:00', 'text4',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-17 19:55:00', 'text5',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-17 19:56:00', 'text6',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-17 19:57:00', 'text7',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-17 19:58:00', 'text8',9999);
INSERT INTO notifications(date, text, user_id) VALUES ('2022-06-17 19:59:00', 'text9',9999);

INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (1,"Plivanje",          0, 	67, 60, 15, 70, 54, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (2,"Atletika",  		0, 	78, 84, 7, 60, 65, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (3,"Macevanje", 		1, 	85, 13, 74, 25, 82, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (4,"Streljarstvo", 		2, 	0, 12, 94, 15, 76, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (5,"Strelicarstvo", 	1, 	0, 12, 92, 16, 87, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (6,"Biatlon", 			2, 	92, 69, 91, 56, 74, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (7,"Triatlon", 			1, 	95, 95, 12, 83, 24, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (8,"Dizanje Tegova", 	0, 	0, 95, 8, 96, 68, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (9,"Badminton", 		0, 	75, 34, 56, 36, 47, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (10,"Tenis", 			2, 	83, 82, 78, 53, 69, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (11,"Judo", 			0, 	64, 25, 25, 78, 82, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (12,"Karate", 			0, 	83, 17, 7, 63, 78, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (13,"Kick Box", 		0, 	82, 85, 74, 74, 83, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (14,"Box", 				0, 	76, 92, 75, 87, 75, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (15,"UFC", 				0, 	81, 93, 82, 95, 85, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (16,"Tekvando", 		0, 	64, 46, 54, 72, 69, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (17,"Stoni Tenis", 		1, 	84, 35, 78, 32, 58, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (18,"Veslanje", 		1, 	73, 79, 23, 83, 37, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (19,"Gimnastika", 		0, 	42, 83, 75, 64, 89, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (20,"Klizanje", 		0, 	65, 32, 53, 25, 72, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (21,"Biciklizam", 		1, 	87, 82, 5, 78, 23, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (22,"Skijanje", 		0, 	71, 82, 58, 25, 69, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (23,"Bilijar", 			0, 	6, 22, 94, 26, 85, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (24,"Pikado", 			0, 	8, 24, 96, 21, 75, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (25,"Kuglanje", 		1, 	22, 19, 89, 32, 89, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (26,"Sah", 				0, 	21, 15, 17, 5, 99, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (27,"Trke Auta", 		2, 	74, 25, 83, 0, 93, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (28,"Trke Motora", 		2, 	75, 65, 86, 35, 95, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (29,"Jahanje", 			2, 	64, 58, 27, 65, 34, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (30,"Curling", 			1, 	21, 12, 84, 32, 73, 3, 2);
INSERT INTO individualni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (31,"Golf", 			2, 	15, 0, 99, 35, 82, 3, 2);


INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (32,"Hokej", 				2, 		54, 34, 57, 76, 45, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (33,"Kosarka", 			0, 		65, 76, 84, 87, 75, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (34,"Odbojka", 			0, 		32, 25, 54, 65, 57, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (35,"Fudbal", 			0, 		82, 63, 53, 45, 57, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (36,"Ragbi", 				0, 		76, 78, 35, 89, 46, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (37,"Rukomet", 			0, 		64, 32, 73, 79, 43, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (38,"Vaterpolo", 			1, 		25, 94, 67, 93, 57, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (39,"Cricket", 			1, 		32, 12, 62, 58, 72, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (40,"Baseball", 			0, 		65, 7, 45, 25, 27, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (41,"Polo", 				2, 		32, 25, 69, 36, 34, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (42,"Double Tenis", 		2, 		74, 78, 82, 72, 67, 3, 2);
INSERT INTO timski_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (43,"Double Stoni Tenis", 1, 		65, 23, 75, 35, 82, 3, 2);


INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (44,"Mount Biking", 	1, 		73, 41, 27, 34, 65, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (45,"Rock Climbing", 	1, 		10, 85, 25, 87, 28, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (46,"Base Jumping", 	0, 		0, 25, 15, 35, 25, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (47,"Bobsleigh", 		2, 		84, 21, 12, 15, 64, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (48,"Free solo", 		0, 		12, 95, 35, 93, 45, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (49,"Freestyle Skiing",2, 		64, 24, 31, 32, 84, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (50,"Paragliding", 	2, 		5, 38, 8, 31, 32, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (51,"Ice Climbing", 	1, 		7, 78, 23, 68, 56, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (52,"Parkour", 		0, 		54, 64, 47, 75, 64, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (53,"Scuba Diving", 	0, 		1, 64, 9, 15, 56, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (54,"Ski Jumping", 	2, 		84, 74,23, 45, 73, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (55,"Skateboarding", 	1, 		25, 21, 12, 27, 82, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (56,"Skydiving", 		2, 		5, 89, 7, 56, 36, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (57,"Water Skiing", 	2, 		48, 31, 31, 25, 67, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (58,"Parachuting", 	2, 		2, 45, 25, 31, 58, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (59,"Surfing", 		0, 		35, 42, 27, 57, 62, 3, 2);
INSERT INTO ekstremni_sport(id,ime, cena, brzina, izdrzljivost, preciznost, snaga, tehnika, vezbe_izdrzljivosti, vezbe_snage) VALUES (60,"Jedrenje", 		2, 		63, 74, 57, 75, 75, 3, 2);


INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (1,1);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,2);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,3);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,4);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,5);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (2,6);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,7);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (1,7);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,8);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,9);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,10);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,11);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,12);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,13);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,14);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,15);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,16);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,17);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (1,18);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,19);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (3,20);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,21);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (2,22);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,23);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,24);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,25);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,26);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,27);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,28);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,29);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (3,30);
INSERT INTO individualna_kategorija(podkategorija, ind_sport_id) VALUES (0,31);

INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,32);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,33);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (1,34);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,35);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,36);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,37);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (0,38);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (2,39);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (2,40);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (2,41);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (1,42);
INSERT INTO timska_kategorija(podkategorija, tim_sport_id) VALUES (1,43);


INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (0,45);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (0,51);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (0,52);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (0,48);

INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,44);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,47);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,49);

INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (2,50);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (2,46);

INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (3,53);





INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,54);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (2,54);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,55);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (2,56);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,57);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (2,58);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,59);
INSERT INTO ekstremna_kategorija(podkategorija, ekst_sport_id) VALUES (1,60);

