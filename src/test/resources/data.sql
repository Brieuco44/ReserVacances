INSERT INTO role (id, nom)
VALUES ('20a8120f-3e86-427c-85d5-7c8703cdea9a', 'ROLE_USER'),
    ('2b051ae7-573c-43d6-4af6-adc3-293afe03', 'ROLE_ADMIN'),
    ('97388c02-993e-4c59-b72d-319efa5e', 'ROLE_CAR_MANAGER');

INSERT INTO utilisateur (id, email, mot_de_passe, nom, prenom, telephone, role_id, username)
VALUES
    ('user1', 'test@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'User 1', 'user1', '0606060606', '2b051ae7-573c-43d6-4af6-adc3-293afe03', 'user1');

INSERT INTO marque (id, nom)
VALUES  ('Marque1', 'Alpine');

INSERT INTO modele_voiture (id, nom,nb_place, description, marque_id )
VALUES  ('ModeleVoiture1', 'Alpine', 5, 'Description Alpine', 'Marque1');

INSERT INTO pays (id, nom)
VALUES  ('Pays1', 'France');
INSERT INTO ville (id, nom,pays_id)
VALUES  ('Ville1', 'Bonchamp', 'Pays1');

INSERT INTO voiture (id, prix, modele_id, ville_id)
VALUES  ('voiture1', 5000, 'ModeleVoiture1','Ville1');

-- Insertion des hôtels de test
INSERT INTO hotel (id, nom, ville_id) VALUES ('Hotel1', 'Hotel Test 1', 'Ville1'), ('Hotel2', 'Hotel Test 2', 'Ville1');

-- Insertion des chambres de test
INSERT INTO chambre (id, nb_place, numero,  prix, hotel_id) VALUES
('Chambre1', 2, '101', 100.0, 'Hotel1'),
('Chambre2', 3, '102', 150.0, 'Hotel1'),
('Chambre3', 2, '201', 120.0, 'Hotel2');