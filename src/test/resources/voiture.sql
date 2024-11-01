INSERT INTO marque (id, nom)
VALUES
    ('7e7bbbf5-5d3b-4bb4-8b92-88a53400d20b', 'Alpine'),
    ('74c05c46-970b-4f4d-bb00-0a7b1cd6e93b', 'Bugatti'),
    ('8bfe2034-8e67-41ed-9463-5e3d2e54f0d8', 'Peugeot'),
    ('afc9aa61-01f1-48e0-bc44-0fa0c79a57bc', 'Citroën'),
    ('5ef799b8-2f91-4bcb-83c8-11553ee1f064', 'Renault'),
    ('aeac5da6-5e98-4bb0-bd00-18489d8d24e3', 'Tesla'),
    ('c0f64c51-0426-4172-b80f-43e5f53b0352', 'BMW'),
    ('489f0f5d-b5b7-40b8-83e5-caa6fbd2c882', 'Mercedes-Benz'),
    ('3137a1b4-bf6a-4645-ae30-4190c77e2cf1', 'Audi'),
    ('d62e85ca-d14b-4a3b-bcad-419c26ff500c', 'Porsche'),
    ('6f52e816-8709-4f3f-bec1-66ab89c51225', 'Ferrari'),
    ('ee7b9e6a-2b7d-44ab-8295-f3081e2e4345', 'Lamborghini'),
    ('d2e5278b-7c03-4e07-9c60-55c7e482c69f', 'Maserati'),
    ('1cb243c8-3794-45b2-a8f4-b5a57b18dc98', 'Aston Martin'),
    ('ff90dc79-f03c-40b1-94b3-e6a8b85e43f3', 'Jaguar'),
    ('16d8c512-4f76-4743-8e51-60dbd6e5eaf9', 'Land Rover'),
    ('63cd1bc1-5c52-4e49-a77c-b14cb47681fc', 'Ford'),
    ('b9f87d89-8175-4700-91b2-7b433b0805d2', 'Chevrolet'),
    ('567d3746-6f27-4ee3-8d29-9081ff9b49d4', 'Honda'),
    ('228c3e49-8a65-4660-b849-1cf59c94370d', 'Toyota');


INSERT INTO modele_voiture (id, nom, nb_place, description, marque_id)
VALUES
    ('c04ab75c-0e75-4b04-8888-fd8a5a63aa2e', 'Alpine A110', 2, 'Coupé sportif français au design élégant et aux performances dynamiques.',
     '7e7bbbf5-5d3b-4bb4-8b92-88a53400d20b'),  -- ID de la marque Alpine
    ('672b3f8c-5270-446f-a8ab-56b2b0364f07', 'Bugatti Chiron', 2, 'Hypercar luxueuse et puissante, célèbre pour sa vitesse record et son style exclusif.',
     '74c05c46-970b-4f4d-bb00-0a7b1cd6e93b'),  -- ID de la marque Bugatti
    ('8aa3aa8b-373c-4345-8e67-c073e2f95f79', 'Peugeot 3008', 5, 'SUV familial spacieux avec un design moderne et une technologie de pointe.',
     '8bfe2034-8e67-41ed-9463-5e3d2e54f0d8'),  -- ID de la marque Peugeot
    ('95f37826-dde8-4f3c-99f7-6d5470a25532', 'Citroën C4', 5, 'Compacte confortable avec un design unique et une conduite souple.',
     'afc9aa61-01f1-48e0-bc44-0fa0c79a57bc'),  -- ID de la marque Citroën
    ('3edfb8a0-8d2f-4695-a47d-54642854d59f', 'Renault Clio', 5, 'Polyvalente et économique, idéale pour la ville avec une touche de sportivité.',
     '5ef799b8-2f91-4bcb-83c8-11553ee1f064'),  -- ID de la marque Renault
    ('bd376f41-fc05-4a60-a3c0-5b2cd3ff64ca', 'Tesla Model S', 5, 'Berline électrique haut de gamme avec une autonomie impressionnante et des performances accrues.',
     'aeac5da6-5e98-4bb0-bd00-18489d8d24e3'),  -- ID de la marque Tesla
    ('40810f36-3c54-43e0-9b60-7c478c95af39', 'BMW X5', 5, 'SUV de luxe offrant confort, puissance et technologie de pointe.',
     'c0f64c51-0426-4172-b80f-43e5f53b0352'),  -- ID de la marque BMW
    ('4fce3d36-67da-4990-b9d7-5d45f7e24571', 'Mercedes-Benz Classe C', 5, 'Berline élégante avec des finitions premium et une conduite raffinée.',
     '489f0f5d-b5b7-40b8-83e5-caa6fbd2c882'),  -- ID de la marque Mercedes-Benz
    ('ba63c5c5-29d0-4a09-8d5d-b21ef2f5b3ec', 'Audi Q7', 7, 'SUV familial spacieux et puissant, parfait pour les longs trajets.',
     '3137a1b4-bf6a-4645-ae30-4190c77e2cf1'),  -- ID de la marque Audi
    ('9e803a8c-e8d7-4f2c-9612-e2d64f92aeb3', 'Porsche 911', 4, 'Icône du design sportif avec des performances exceptionnelles et un charme intemporel.',
     'd62e85ca-d14b-4a3b-bcad-419c26ff500c'),  -- ID de la marque Porsche
    ('49d7a4e1-1d46-46ff-8162-e75a1d98b9f3', 'Ferrari 488', 2, 'Supercar italienne légendaire avec des performances élevées et un style incomparable.',
     '6f52e816-8709-4f3f-bec1-66ab89c51225'),  -- ID de la marque Ferrari
    ('cc6d0b04-12f2-4764-a07a-4d5ea1581c2d', 'Lamborghini Huracán', 2, 'Voiture de sport à couper le souffle avec une puissance brute et un look audacieux.',
     'ee7b9e6a-2b7d-44ab-8295-f3081e2e4345'),  -- ID de la marque Lamborghini
    ('8707f02c-b21f-43d4-9b91-743006cf6c8e', 'Maserati Levante', 5, 'SUV luxueux combinant élégance italienne et puissance pour tous les terrains.',
     'd2e5278b-7c03-4e07-9c60-55c7e482c69f'),  -- ID de la marque Maserati
    ('8ab62249-c021-4f01-8a49-46e4d8123af7', 'Aston Martin DB11', 4, 'GT britannique élégante, synonyme de sophistication et de performance.',
     '1cb243c8-3794-45b2-a8f4-b5a57b18dc98'),  -- ID de la marque Aston Martin
    ('cc1e9a39-cc82-42f7-bc7b-5e99d8a5bb9c', 'Jaguar F-PACE', 5, 'SUV alliant luxe, performance et un design audacieux signé Jaguar.',
     'ff90dc79-f03c-40b1-94b3-e6a8b85e43f3'),  -- ID de la marque Jaguar
    ('d07eea9f-8f9e-47c8-b0a7-5c6588f17098', 'Land Rover Range Rover', 5, 'SUV emblématique offrant un luxe inégalé et des capacités tout-terrain.',
     '16d8c512-4f76-4743-8e51-60dbd6e5eaf9'),  -- ID de la marque Land Rover
    ('67963e29-7321-4da3-bff6-3f3de3efc6fa', 'Ford Mustang', 4, 'Muscle car américaine iconique, symbolisant la puissance et la liberté.',
     '63cd1bc1-5c52-4e49-a77c-b14cb47681fc'),  -- ID de la marque Ford
    ('303c4c77-1d3c-4b89-b72c-c264c9a5c4da', 'Chevrolet Camaro', 4, 'Voiture de sport musclée au design captivant et aux performances envoûtantes.',
     'b9f87d89-8175-4700-91b2-7b433b0805d2'),  -- ID de la marque Chevrolet
    ('da01be2f-2c4d-43f5-a17b-86cf1f97c1bc', 'Honda Civic', 5, 'Compacte fiable et économique, dotée de technologies avancées.',
     '567d3746-6f27-4ee3-8d29-9081ff9b49d4');  -- ID de la marque Honda



INSERT INTO voiture (id, prix, modele_id, ville_id)
VALUES
    ('a1d38d1f-4e72-4f5f-9a71-161c5b209e99', 200, 'c04ab75c-0e75-4b04-8888-fd8a5a63aa2e', 'cb227084-0bd5-4402-942f-169d00e0997b'),  -- Alpine A110, Paris
    ('b2e15e7b-bf91-4118-9fc0-9b6d1c8fcadb', 1200, '672b3f8c-5270-446f-a8ab-56b2b0364f07', 'c63f4406-5485-47b7-a13c-443dea1de0bd'),  -- Bugatti Chiron, New York
    ('c2a9e65e-0179-40f1-9e1b-b4c2f9b80d32', 80, '8aa3aa8b-373c-4345-8e67-c073e2f95f79', '2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4'),  -- Peugeot 3008, Tokyo
    ('d3c1e8b2-29c3-49b0-8a5e-b12c4d94f624', 60, '95f37826-dde8-4f3c-99f7-6d5470a25532', '3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1'),  -- Citroën C4, Berlin
    ('e4d5f1a1-0a7f-4c67-bb7b-c3347e27cfaf', 50, '3edfb8a0-8d2f-4695-a47d-54642854d59f', '4bfa2c9e-1485-4a52-9c6c-88132fcd0496'),  -- Renault Clio, London
    ('f5e6c7c5-4b8e-4765-8b60-9a4b6ebca3e1', 150, 'bd376f41-fc05-4a60-a3c0-5b2cd3ff64ca', 'f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8'),  -- Tesla Model S, Sydney
    ('g6f7d9e9-4898-4f4a-b6f6-1c9ec1b5c6d2', 200, '40810f36-3c54-43e0-9b60-7c478c95af39', 'ea0eaf12-30d2-4f61-9a04-b6342c4a1c42'),  -- BMW X5, Rome
    ('h8f8e8e1-278f-4389-9b79-8f4c678b9f72', 100, '4fce3d36-67da-4990-b9d7-5d45f7e24571', 'c71f73bc-650c-43d5-a6ef-9167658eb5b9'),  -- Mercedes-Benz Classe C, Madrid
    ('i9a9b3a4-7c3b-4076-b2b1-f8c9d8a2b1e3', 90, 'ba63c5c5-29d0-4a09-8d5d-b21ef2f5b3ec', '9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d'),  -- Audi Q7, São Paulo
    ('j0d0e9f6-1c2f-4a28-82c5-b7d0f2e0c4a4', 150, '9e803a8c-e8d7-4f2c-9612-e2d64f92aeb3', '6632f78e-4a7b-4205-bc68-182ea25bc59b'),  -- Porsche 911, Moscow
    ('k1e1f5c5-67b2-4874-9d8f-f3c7b0d1d5b1', 250, '49d7a4e1-1d46-46ff-8162-e75a1d98b9f3', 'cb227084-0bd5-4402-942f-169d00e0997b'),  -- Ferrari 488, Paris
    ('l2f2d7b8-6c62-43d2-9e4e-6b3e2d5a7c2f', 300, 'cc6d0b04-12f2-4764-a07a-4d5ea1581c2d', 'c63f4406-5485-47b7-a13c-443dea1de0bd'),  -- Lamborghini Huracán, New York
    ('m3g3e9c9-97a7-40a9-80b5-4c5b3f5d9d1e', 250, '8707f02c-b21f-43d4-9b91-743006cf6c8e', '2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4'),  -- Maserati Levante, Tokyo
    ('n4h4d1f2-87c1-4586-80b5-8d4e4c5d3e2f', 200, '8ab62249-c021-4f01-8a49-46e4d8123af7', '3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1'),  -- Aston Martin DB11, Berlin
    ('o5i5e3g3-2f9a-4424-9b1b-5e4f3d2f8f3g', 90, 'cc1e9a39-cc82-42f7-bc7b-5e99d8a5bb9c', '4bfa2c9e-1485-4a52-9c6c-88132fcd0496'),  -- Jaguar F-PACE, London
    ('p6j6f5h4-7c2d-42c3-9c8f-9e3f5d3c8g4h', 120, 'd07eea9f-8f9e-47c8-b0a7-5c6588f17098', 'f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8'),  -- Land Rover Range Rover, Sydney
    ('q7k7g8j5-8b3f-4b9e-8f7e-4f4b4f3g8h5i', 70, '67963e29-7321-4da3-bff6-3f3de3efc6fa', 'ea0eaf12-30d2-4f61-9a04-b6342c4a1c42'),  -- Ford Mustang, Rome
    ('r8l8h9k6-9c4e-493c-9a1b-6d5b5c3h9i6j', 60, '303c4c77-1d3c-4b89-b72c-c264c9a5c4da', 'c71f73bc-650c-43d5-a6ef-9167658eb5b9'),  -- Chevrolet Camaro, Madrid
    ('s9m9i0l7-0d5f-4b0b-89e2-7d6c6d3i0j7k', 50, 'da01be2f-2c4d-43f5-a17b-86cf1f97c1bc', '9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d');  -- Honda Civic, São Paulo


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