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