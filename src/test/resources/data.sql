INSERT INTO role (id, nom) VALUES
('ROLE_USER', 'ROLE_USER'),
('ROLE_ADMIN', 'ROLE_ADMIN'),
('ROLE_CAR_MANAGER', 'ROLE_CAR_MANAGER'),
('ROLE_HOTEL_MANAGER', 'ROLE_HOTEL_MANAGER'),
('ROLE_VOL_MANAGER', 'ROLE_VOL_MANAGER');

INSERT INTO utilisateur (id, email, mot_de_passe, nom, prenom, telephone, role_id, username)
VALUES ('fa064aa8-80de-439e-8ab7-28084e55985c', 'admin@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Admin User',
        'admin', '0606060607', 'ROLE_ADMIN', 'admin'),
       ('user', 'admin@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Admin User',
        'admin', '0606060607', 'ROLE_ADMIN', 'user'),
       ('677966bb-7ab3-4e5a-8208-c1dde5d7fa5e', 'carmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Car Manager',
        'carmanager', '0606060608', 'ROLE_CAR_MANAGER', 'carmanager'),
       ('fe7213b9-6b46-4325-bb2d-33f9c64a98bf', 'hotelmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia',
        'Hotel Manager', 'hotelmanager', '0606060609', 'ROLE_HOTEL_MANAGER', 'hotelmanager'),
       ('f076f233-bf3e-49eb-ad94-d67b5bf95dbe', 'volmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Vol Manager',
        'volmanager', '0606060610', 'ROLE_VOL_MANAGER', 'volmanager');

INSERT INTO pays (id, nom)
VALUES ('France', 'France'),
       ('USA', 'United States'),
       ('Japan', 'Japan'),
       ('Germany', 'Germany'),
       ('United Kingdom', 'United Kingdom'),
       ('Australia', 'Australia'),
       ('Italy', 'Italy'),
       ('Spain', 'Spain'),
       ('Brazil', 'Brazil'),
       ('Russia', 'Russia');

INSERT INTO ville (id, nom, pays_id)
VALUES ('Paris', 'Paris', 'France'),  -- France
       ('New York', 'New York', 'USA'),  -- United States
       ('Tokyo', 'Tokyo', 'Japan'),  -- Japan
       ('Berlin', 'Berlin', 'Germany'),  -- Germany
       ('London', 'London', 'United Kingdom'),  -- United Kingdom
       ('Sydney', 'Sydney', 'Australia'),  -- Australia
       ('Rome', 'Rome', 'Italy'),  -- Italy
       ('Madrid', 'Madrid', 'Spain'),  -- Spain
       ('São Paulo', 'São Paulo', 'Brazil'),  -- Brazil
       ('Moscow', 'Moscow', 'Russia');  -- Russia


INSERT INTO modele_avion (id, nb_place, nom)
VALUES ('5b9a27f7-6781-4af9-8f0a-4d8a6c77c8e1', 180, 'Boeing 737'),
       ('6c1a38e8-7892-4bf9-9a1b-5e9b7d88d9f2', 215, 'Airbus A320'),
       ('7d2a49f9-8903-4cf9-9b2c-6f0c8e99e0f3', 314, 'Boeing 777'),
       ('8e3a5af0-9014-4df9-9c3d-7g1d9fa1f104', 160, 'Embraer E195'),
       ('9f4a6bf1-0125-4ef9-9d4e-8h2e0gb2g215', 240, 'Airbus A321neo'),
       ('1a5b7c02-1236-4ff9-9e5f-9i3f1hc3h326', 280, 'Boeing 787 Dreamliner'),
       ('2b6c8d13-2347-4gf9-9f6g-aj4g2id4i437', 98, 'Bombardier CRJ900'),
       ('3c7d9e24-3458-4hf9-9g7h-bk5h3je5j548', 158, 'Airbus A220'),
       ('4d8eaf35-4569-4if9-9h8i-cl6i4kf6k659', 853, 'Boeing 747'),
       ('5e9fb046-567a-4jf9-9i9j-dm7j5lg7l760', 300, 'McDonnell Douglas MD-11'),
       ('6f1gc157-678b-4kf9-9j0k-en8k6mh8m871', 300, 'Airbus A330'),
       ('7g2hd268-789c-4lf9-9k1l-fo9l7ni9n982', 136, 'Airbus A319'),
       ('8h3ie379-890d-4mf9-9l2m-gp0m8oj0o093', 108, 'Embraer E175'),
       ('9i4jf480-901e-4ng9-9m3n-hq1n9pk1p1a4', 180, 'Boeing 757'),
       ('1j5kg591-012f-4oh9-9n4o-ir2o0ql2q2b5', 100, 'ATR 72'),
       ('2k6lh6a2-123g-4pi9-9o5p-js3p1rm3r3c6', 66, 'Cessna 208 Caravan'),
       ('3l7mi7b3-234h-4qj9-9p6q-kt4q2sn4s4d7', 150, 'Airbus A318'),
       ('4m8nj8c4-345i-4rk9-9q7r-lu5r3to5t5e8', 85, 'De Havilland Dash 8 Q400');

INSERT INTO aeroport (id, nom, ville_id)
VALUES ('3b7b2e63-e9a0-4a5c-b6f6-1f2bb4938a84', 'Aéroport de Roissy-Charles de Gaulle',
        'Paris'), -- Paris, France
       ('92b12348-8bc9-4e67-b3be-36af95bcfc9c', 'Aéroport de Los Angeles International (LAX)',
        'New York'), -- NY, USA
       ('efb83dc7-b2b6-4f55-8bff-5f162c5a8b90', 'Aéroport international de Narita',
        'Tokyo'), -- Tokyo, Japan
       ('e1d51b5f-84f4-4d82-a423-51c0986edfe7', 'Aéroport de Heathrow',
        'London'), -- Londres, Royaume-Uni
       ('eb403f79-efc3-41c5-9105-929aa15c7206', 'Aéroport de Sydney',
        'Sydney'), -- Sydney, Australie
       ('4a7e4b91-1bfa-4a3f-9302-cf5801dc644b', 'Aéroport de Rome-Fiumicino',
        'Rome'), -- Rome, Italie
       ('456f4f29-f322-4649-b2a0-80ee4cb0c367', 'Aéroport international de São Paulo-Guarulhos',
        'São Paulo'), -- São Paulo, Brésil
       ('c7e5b07f-6b66-4042-a574-3e295b7eac8c', 'Aéroport international de Sheremetyevo',
        'Moscow'); -- Moscou, Russie


INSERT INTO compagnie (id, nom)
VALUES ('a26cb918-3d9c-49c8-9c79-3cde3eab0b6f', 'Lufthansa'),
       ('b37dc029-4eac-4ad8-9d7a-4def4fbc1c7d', 'Air France'),
       ('c48ed13a-5fbd-4be8-9e7b-5efg5gdc2d8e', 'EasyJet'),
       ('d59fe24b-6gce-4cf8-9f7c-6fgh6hde3e9f', 'Ryanair'),
       ('e60gf35c-7hdg-4dg8-9g7d-7gih7idf4f0g', 'British Airways'),
       ('f71gh46d-8ieh-4eh8-9h7e-8hih8jeg5g1h', 'KLM Royal Dutch Airlines'),
       ('g82hi57e-9jfi-4fi8-9i7f-9ijh9kfh6h2i', 'Emirates'),
       ('h93ij68f-0kgj-4gj8-9j7g-0jki0lgi7i3j', 'Qatar Airways');

INSERT INTO modele_avion (id, nb_place, nom)
VALUES ('4a8f91e6-5670-44f6-a469-341fa9d65c3d', 350, 'A380'),            -- Airbus A380
       ('dca5c614-63e6-4df1-a6a5-604256d78f35', 200, 'A320'),            -- Airbus A320
       ('7d5e504c-5fa1-4978-b8c5-8c5c2c129a2f', 250, 'Boeing 737'),      -- Boeing 737
       ('b3cbe71c-d61e-4a14-a09b-63774b3d1a11', 300, 'Boeing 787'),      -- Boeing 787
       ('0e2c7c9e-63c5-4f43-a6c2-f64f58a5dcbc', 130, 'Embraer E175');     -- Embraer E175


INSERT INTO avion (id, compagnie_id, modele_avion_id)
VALUES ('93eeb9ac-0e5f-47c6-ae38-65758d0d5d34', 'a26cb918-3d9c-49c8-9c79-3cde3eab0b6f', '5b9a27f7-6781-4af9-8f0a-4d8a6c77c8e1'),  -- Lufthansa, Boeing 737
       ('b04531af-2d80-45f4-9f62-b7c4ae761f18', 'b37dc029-4eac-4ad8-9d7a-4def4fbc1c7d', '6c1a38e8-7892-4bf9-9a1b-5e9b7d88d9f2'),  -- Air France, Airbus A320
       ('e6c89c5c-bd6f-45f6-8a7f-39ab0e59dcbd', 'c48ed13a-5fbd-4be8-9e7b-5efg5gdc2d8e', '7d2a49f9-8903-4cf9-9b2c-6f0c8e99e0f3'),  -- EasyJet, Boeing 777
       ('94c7d74e-50d6-4b3e-8185-66fbb704e1b4', 'd59fe24b-6gce-4cf8-9f7c-6fgh6hde3e9f', '8e3a5af0-9014-4df9-9c3d-7g1d9fa1f104'),  -- Ryanair, Embraer E195
       ('b94c0b5f-4c92-47b3-bc90-25c59f8c20e3', 'e60gf35c-7hdg-4dg8-9g7d-7gih7idf4f0g', '9f4a6bf1-0125-4ef9-9d4e-8h2e0gb2g215');  -- British Airways, Airbus A321neo


INSERT INTO vol (id, date_debut, date_fin, prix_adulte,prix_enfant, aeroport_depart_id, aeroport_arrivee_id, avion_id)
VALUES ('c6b2c7bb-3046-4b4f-9087-9a76a77e7e4f', '2024-11-15 10:00:00', '2024-11-15 14:00:00', 200, 100,
        '3b7b2e63-e9a0-4a5c-b6f6-1f2bb4938a84', '92b12348-8bc9-4e67-b3be-36af95bcfc9c',
        '93eeb9ac-0e5f-47c6-ae38-65758d0d5d34'),  -- Paris to LA
       ('d99f6d79-1683-4f9f-bdaf-f6e237bda9f6', '2024-11-16 15:00:00', '2024-11-16 20:00:00', 250, 150,
        '92b12348-8bc9-4e67-b3be-36af95bcfc9c', 'efb83dc7-b2b6-4f55-8bff-5f162c5a8b90',
        'b04531af-2d80-45f4-9f62-b7c4ae761f18'),  -- LA to Tokyo
       ('f46da1f8-5745-4e84-93c5-8b84a337aa83', '2024-11-17 08:00:00', '2024-11-17 12:00:00', 180, 90,
        'efb83dc7-b2b6-4f55-8bff-5f162c5a8b90', 'eb403f79-efc3-41c5-9105-929aa15c7206',
        'e6c89c5c-bd6f-45f6-8a7f-39ab0e59dcbd'),  -- Tokyo to Frankfurt
       ('4a8d0b77-b9c8-4638-b8f4-2f707bdf8e4e', '2024-11-18 09:00:00', '2024-11-18 11:30:00', 300, 200,
        'eb403f79-efc3-41c5-9105-929aa15c7206', 'e1d51b5f-84f4-4d82-a423-51c0986edfe7',
        '94c7d74e-50d6-4b3e-8185-66fbb704e1b4');  -- Frankfurt to London


INSERT INTO reservation_vol (id, nb_adulte, nb_enfant, utilisateur_id, vol_id)
VALUES ('84b0d8cc-5a2b-4906-a85f-693b58d676b3', 1, 0, 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c6b2c7bb-3046-4b4f-9087-9a76a77e7e4f'),  -- Reservation for Paris to LA
       ('7b3a0d6a-2b0f-4e99-bd72-307b5d41e64d', 2, 1, '677966bb-7ab3-4e5a-8208-c1dde5d7fa5e', 'd99f6d79-1683-4f9f-bdaf-f6e237bda9f6'),  -- Reservation for LA to Tokyo
       ('dbcb47b8-52bc-48f4-9f61-c768f5dfc9f4', 1, 0, 'fe7213b9-6b46-4325-bb2d-33f9c64a98bf', 'f46da1f8-5745-4e84-93c5-8b84a337aa83'),  -- Reservation for Tokyo to Frankfurt
       ('fc5c4c1d-fc7e-4d69-9b9a-91b2a38e4dcb', 2, 2, 'fa064aa8-80de-439e-8ab7-28084e55985c', '4a8d0b77-b9c8-4638-b8f4-2f707bdf8e4e');  -- Reservation for Frankfurt to London





INSERT INTO marque (id, nom)
VALUES
    ('Alpine', 'Alpine'),
    ('Bugatti', 'Bugatti'),
    ('Peugeot', 'Peugeot'),
    ('Citroën', 'Citroën'),
    ('Renault', 'Renault'),
    ('Tesla', 'Tesla'),
    ('BMW', 'BMW'),
    ('Mercedes-Benz', 'Mercedes-Benz'),
    ('Audi', 'Audi'),
    ('Porsche', 'Porsche'),
    ('Ferrari', 'Ferrari'),
    ('Lamborghini', 'Lamborghini'),
    ('Maserati', 'Maserati'),
    ('Aston Martin', 'Aston Martin'),
    ('Jaguar', 'Jaguar'),
    ('Land Rover', 'Land Rover'),
    ('Ford', 'Ford'),
    ('Chevrolet', 'Chevrolet'),
    ('Honda', 'Honda'),
    ('Toyota', 'Toyota');


INSERT INTO modele_voiture (id, nom, nb_place, description, marque_id)
VALUES
    ('Alpine A110', 'Alpine A110', 2, 'Coupé sportif français au design élégant et aux performances dynamiques.',
     'Alpine'),  -- ID de la marque Alpine
    ('Bugatti Chiron', 'Bugatti Chiron', 2, 'Hypercar luxueuse et puissante, célèbre pour sa vitesse record et son style exclusif.',
     'Bugatti'),  -- ID de la marque Bugatti
    ('Peugeot 3008', 'Peugeot 3008', 5, 'SUV familial spacieux avec un design moderne et une technologie de pointe.',
     'Peugeot'),  -- ID de la marque Peugeot
    ('Citroën C4', 'Citroën C4', 5, 'Compacte confortable avec un design unique et une conduite souple.',
     'Citroën'),  -- ID de la marque Citroën
    ('Renault Clio', 'Renault Clio', 5, 'Polyvalente et économique, idéale pour la ville avec une touche de sportivité.',
     'Renault'),  -- ID de la marque Renault
    ('Tesla Model S', 'Tesla Model S', 5, 'Berline électrique haut de gamme avec une autonomie impressionnante et des performances accrues.',
     'Tesla'),  -- ID de la marque Tesla
    ('BMW X5', 'BMW X5', 5, 'SUV de luxe offrant confort, puissance et technologie de pointe.',
     'BMW'),  -- ID de la marque BMW
    ('Mercedes-Benz Classe C', 'Mercedes-Benz Classe C', 5, 'Berline élégante avec des finitions premium et une conduite raffinée.',
     'Mercedes-Benz'),  -- ID de la marque Mercedes-Benz
    ('Audi Q7', 'Audi Q7', 7, 'SUV familial spacieux et puissant, parfait pour les longs trajets.',
     'Audi'),  -- ID de la marque Audi
    ('Porsche 911', 'Porsche 911', 4, 'Icône du design sportif avec des performances exceptionnelles et un charme intemporel.',
     'Porsche'),  -- ID de la marque Porsche
    ('Ferrari 488', 'Ferrari 488', 2, 'Supercar italienne légendaire avec des performances élevées et un style incomparable.',
     'Ferrari'),  -- ID de la marque Ferrari
    ('Lamborghini Huracán', 'Lamborghini Huracán', 2, 'Voiture de sport à couper le souffle avec une puissance brute et un look audacieux.',
     'Lamborghini'),  -- ID de la marque Lamborghini
    ('Maserati Levante', 'Maserati Levante', 5, 'SUV luxueux combinant élégance italienne et puissance pour tous les terrains.',
     'Maserati'),  -- ID de la marque Maserati
    ('Aston Martin DB11', 'Aston Martin DB11', 4, 'GT britannique élégante, synonyme de sophistication et de performance.',
     'Aston Martin'),  -- ID de la marque Aston Martin
    ('Jaguar F-PACE', 'Jaguar F-PACE', 5, 'SUV alliant luxe, performance et un design audacieux signé Jaguar.',
     'Jaguar'),  -- ID de la marque Jaguar
    ('Land Rover Range Rover', 'Land Rover Range Rover', 5, 'SUV emblématique offrant un luxe inégalé et des capacités tout-terrain.',
     'Land Rover'),  -- ID de la marque Land Rover
    ('Ford Mustang', 'Ford Mustang', 4, 'Muscle car américaine iconique, symbolisant la puissance et la liberté.',
     'Ford'),  -- ID de la marque Ford
    ('Chevrolet Camaro', 'Chevrolet Camaro', 4, 'Voiture de sport musclée au design captivant et aux performances envoûtantes.',
     'Chevrolet'),  -- ID de la marque Chevrolet
    ('Honda Civic', 'Honda Civic', 5, 'Compacte fiable et économique, dotée de technologies avancées.',
     'Honda');  -- ID de la marque Honda



INSERT INTO voiture (id, prix, modele_id, ville_id)
VALUES
    ('a1d38d1f-4e72-4f5f-9a71-161c5b209e99', 200, 'Alpine A110', 'Paris'),  -- Alpine A110, Paris
    ('b2e15e7b-bf91-4118-9fc0-9b6d1c8fcadb', 1200, 'Bugatti Chiron', 'New York'),  -- Bugatti Chiron, New York
    ('c2a9e65e-0179-40f1-9e1b-b4c2f9b80d32', 80, 'Peugeot 3008', 'Tokyo'),  -- Peugeot 3008, Tokyo
    ('d3c1e8b2-29c3-49b0-8a5e-b12c4d94f624', 60, 'Citroën C4', 'Berlin'),  -- Citroën C4, Berlin
    ('e4d5f1a1-0a7f-4c67-bb7b-c3347e27cfaf', 50, 'Renault Clio', 'London'),  -- Renault Clio, London
    ('f5e6c7c5-4b8e-4765-8b60-9a4b6ebca3e1', 150, 'Tesla Model S', 'Sydney'),  -- Tesla Model S, Sydney
    ('g6f7d9e9-4898-4f4a-b6f6-1c9ec1b5c6d2', 200, 'BMW X5', 'Rome'),  -- BMW X5, Rome
    ('h8f8e8e1-278f-4389-9b79-8f4c678b9f72', 100, 'Mercedes-Benz Classe C', 'Madrid'),  -- Mercedes-Benz Classe C, Madrid
    ('i9a9b3a4-7c3b-4076-b2b1-f8c9d8a2b1e3', 90, 'Audi Q7', 'São Paulo'),  -- Audi Q7, São Paulo
    ('j0d0e9f6-1c2f-4a28-82c5-b7d0f2e0c4a4', 150, 'Porsche 911', 'Moscow'),  -- Porsche 911, Moscow
    ('k1e1f5c5-67b2-4874-9d8f-f3c7b0d1d5b1', 250, 'Ferrari 488', 'Paris'),  -- Ferrari 488, Paris
    ('l2f2d7b8-6c62-43d2-9e4e-6b3e2d5a7c2f', 300, 'Lamborghini Huracán', 'New York'),  -- Lamborghini Huracán, New York
    ('m3g3e9c9-97a7-40a9-80b5-4c5b3f5d9d1e', 250, 'Maserati Levante', 'Tokyo'),  -- Maserati Levante, Tokyo
    ('n4h4d1f2-87c1-4586-80b5-8d4e4c5d3e2f', 200, 'Aston Martin DB11', 'Berlin'),  -- Aston Martin DB11, Berlin
    ('o5i5e3g3-2f9a-4424-9b1b-5e4f3d2f8f3g', 90, 'Jaguar F-PACE', 'London'),  -- Jaguar F-PACE, London
    ('p6j6f5h4-7c2d-42c3-9c8f-9e3f5d3c8g4h', 120, 'Land Rover Range Rover', 'Sydney'),  -- Land Rover Range Rover, Sydney
    ('q7k7g8j5-8b3f-4b9e-8f7e-4f4b4f3g8h5i', 70, 'Ford Mustang', 'Rome'),  -- Ford Mustang, Rome
    ('r8l8h9k6-9c4e-493c-9a1b-6d5b5c3h9i6j', 60, 'Chevrolet Camaro', 'Madrid'),  -- Chevrolet Camaro, Madrid
    ('s9m9i0l7-0d5f-4b0b-89e2-7d6c6d3i0j7k', 50, 'Honda Civic', 'São Paulo');  -- Honda Civic, São Paulo


INSERT INTO reservation_voiture (id, date_debut, date_fin, utilisateur_id, voiture_id)
VALUES
    ('a1d38d1f-4e72-4f5f-9a71-161c5b209e99', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'a1d38d1f-4e72-4f5f-9a71-161c5b209e99'),
    ('b2e15e7b-bf91-4118-9fc0-9b6d1c8fcadb', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'b2e15e7b-bf91-4118-9fc0-9b6d1c8fcadb'),
    ('c2a9e65e-0179-40f1-9e1b-b4c2f9b80d32', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c2a9e65e-0179-40f1-9e1b-b4c2f9b80d32'),
    ('d3c1e8b2-29c3-49b0-8a5e-b12c4d94f624', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'd3c1e8b2-29c3-49b0-8a5e-b12c4d94f624'),
    ('e4d5f1a1-0a7f-4c67-bb7b-c3347e27cfaf', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'e4d5f1a1-0a7f-4c67-bb7b-c3347e27cfaf'),
    ('f5e6c7c5-4b8e-4765-8b60-9a4b6ebca3e1', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'f5e6c7c5-4b8e-4765-8b60-9a4b6ebca3e1'),
    ('g6f7d9e9-4898-4f4a-b6f6-1c9ec1b5c6d2', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'g6f7d9e9-4898-4f4a-b6f6-1c9ec1b5c6d2'),
    ('h8f8e8e1-278f-4389-9b79-8f4c678b9f72', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'h8f8e8e1-278f-4389-9b79-8f4c678b9f72'),
    ('i9a9b3a4-7c3b-4076-b2b1-f8c9d8a2b1e3', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'i9a9b3a4-7c3b-4076-b2b1-f8c9d8a2b1e3'),
    ('j0d0e9f6-1c2f-4a28-82c5-b7d0f2e0c4a4', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'j0d0e9f6-1c2f-4a28-82c5-b7d0f2e0c4a4'),
    ('k1e1f5c5-67b2-4874-9d8f-f3c7b0d1d5b1', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'k1e1f5c5-67b2-4874-9d8f-f3c7b0d1d5b1'),
    ('l2f2d7b8-6c62-43d2-9e4e-6b3e2d5a7c2f', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'l2f2d7b8-6c62-43d2-9e4e-6b3e2d5a7c2f');




INSERT INTO hotel (id, nom, ville_id)
VALUES ('h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f', 'Hôtel de Paris', 'Paris'), -- Paris
       ('h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o', 'The New Yorker', 'New York'), -- New York
       ('h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c', 'Shinjuku Granbell Hotel', 'Tokyo'),   -- Tokyo
       ('h1z2a3b4-5c6d-7e8f-9g0h-1i2j3k4l5m6n', 'Hotel Berlin', 'Berlin'),   -- Berlin
       ('h1m2n3o4-5p6q-7r8s-9t0u-1v2w3x4y5z6a', 'The Montcalm London', 'London'),   -- London
       ('h1f2g3h4-5i6j-7k8l-9m0n-1o2p3q4r5s6t', 'Sydney Harbour Marriott', 'Sydney'),  -- Sydney
       ('h1u2v3w4-5x6y-7z8a-9b0c-1d2e3f4g5h6i', 'Hôtel Roma', 'Rome'),     -- Rome
       ('h1j2k3l4-5m6n-7o8p-9q0r-1s2t3u4v5w6x', 'Hotel Madrid', 'Madrid'),   -- Madrid
       ('h1y2z3a4-5b6c-7d8e-9f0g-1h2i3j4k5l6m', 'Hotel Unique', 'São Paulo'),   -- São Paulo
       ('h1n2o3p4-5q6r-7s8t-9u0v-1w2x3y4z5a6b', 'Ararat Park Hyatt', 'Moscow'); -- Moscow

INSERT INTO chambre (id, nb_place, numero, prix, hotel_id)
VALUES
    ('c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f', 1, '101', 100.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o', 2, '102', 200.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c', 1, '103', 100.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c1z2a3b4-5c6d-7e8f-9g0h-1i2j3k4l5m6n', 2, '104', 200.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c1m2n3o4-5p6q-7r8s-9t0u-1v2w3x4y5z6a', 1, '105', 100.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c2f3g4h5-6i7j-8k9l-0m1n-2o3p4q5r6s7t', 2, '106', 200.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c2u3v4w5-6x7y-8z9a-0b1c-2d3e4f5g6h7i', 1, '107', 100.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c2j3k4l5-6m7n-8o9p-0q1r-2s3t4u5v6w7x', 2, '108', 200.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c2y3z4a5-6b7c-8d9e-0f1g-2h3i4j5k6l7m', 1, '109', 100.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c2n3o4p5-6q7r-8s9t-0u1v-2w3x4y5z6a7b', 2, '110', 200.0, 'h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('c3d4e5f6-7g8h-9i0j-1k2l-3m4n5o6p7q8r', 1, '101', 100.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c3a4b5c6-7d8e-9f0g-1h2i-3j4k5l6m7n8o', 2, '102', 200.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c3o4p5q6-7r8s-9t0u-1v2w-3x4y5z6a7b8c', 1, '103', 100.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c3z4a5b6-7c8d-9e0f-1g2h-3i4j5k6l7m8n', 2, '104', 200.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c3m4n5o6-7p8q-9r0s-1t2u-3v4w5x6y7z8a', 1, '105', 100.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c4f5g6h7-8i9j-0k1l-2m3n-4o5p6q7r8s9t', 2, '106', 200.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c4u5v6w7-8x9y-0z1a-2b3c-4d5e6f7g8h9i', 1, '107', 100.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c4j5k6l7-8m9n-0o1p-2q3r-4s5t6u7v8w9x', 2, '108', 200.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c4y5z6a7-8b9c-0d1e-2f3g-4h5i6j7k8l9m', 1, '109', 100.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c4n5o6p7-8q9r-0s1t-2u3v-4w5x6y7z8a9b', 2, '110', 200.0, 'h1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('c5d6e7f8-9g0h-1i2j-3k4l-5m6n7o8p9q0r', 1, '101', 100.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c5a6b7c8-9d0e-1f2g-3h4i-5j6k7l8m9n0o', 2, '102', 200.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c5o6p7q8-9r0s-1t2u-3v4w-5x6y7z8a9b0c', 1, '103', 100.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c5z6a7b8-9c0d-1e2f-3g4h-5i6j7k8l9m0n', 2, '104', 200.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c5m6n7o8-9p0q-1r2s-3t4u-5v6w7x8y9z0a', 1, '105', 100.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c6f7g8h9-0i1j-2k3l-4m5n-6o7p8q9r0s1t', 2, '106', 200.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c6u7v8w9-0x1y-2z3a-4b5c-6d7e8f9g0h1i', 1, '107', 100.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('c6j7k8l9-0m1n-2o3p-4q5r-6s7t8u9v0w1x', 2, '108', 200.0, 'h1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c');

INSERT INTO reservation_hotel (id, date_debut, date_fin, utilisateur_id, chambre_id)
VALUES
    ('r1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f'),
    ('r1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o'),
    ('r1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c1o2p3q4-5r6s-7t8u-9v0w-1x2y3z4a5b6c'),
    ('r1z2a3b4-5c6d-7e8f-9g0h-1i2j3k4l5m6n', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c1z2a3b4-5c6d-7e8f-9g0h-1i2j3k4l5m6n'),
    ('r1m2n3o4-5p6q-7r8s-9t0u-1v2w3x4y5m6n', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c1m2n3o4-5p6q-7r8s-9t0u-1v2w3x4y5z6a'),
    ('r1f2g3h4-5i6j-7k8l-9m0n-1o2p3q4r5s6t', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c2f3g4h5-6i7j-8k9l-0m1n-2o3p4q5r6s7t'),
    ('r1u2v3w4-5x6y-7z8a-9b0c-1d2e3f4g5h6i', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c2u3v4w5-6x7y-8z9a-0b1c-2d3e4f5g6h7i'),
    ('r1j2k3l4-5m6n-7o8p-9q0r-1s2t3u4v5w6x', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c2j3k4l5-6m7n-8o9p-0q1r-2s3t4u5v6w7x'),
    ('r1y2z3a4-5b6c-7d8e-9f0g-1h2i3j4k5l6m', '2024-10-02', '2024-10-03', 'fa064aa8-80de-439e-8ab7-28084e55985c', 'c4y5z6a7-8b9c-0d1e-2f3g-4h5i6j7k8l9m');




