INSERT INTO role (id, nom) VALUES
('ROLE_USER', 'ROLE_USER'),
('ROLE_ADMIN', 'ROLE_ADMIN'),
('ROLE_CAR_MANAGER', 'ROLE_CAR_MANAGER'),
('ROLE_HOTEL_MANAGER', 'ROLE_HOTEL_MANAGER'),
('ROLE_VOL_MANAGER', 'ROLE_VOL_MANAGER');

INSERT INTO utilisateur (id, email, mot_de_passe, nom, prenom, telephone, role_id, username)
VALUES ('fa064aa8-80de-439e-8ab7-28084e55985c', 'admin@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Admin User',
        'admin', '0606060607', 'ROLE_ADMIN', 'admin'),
       ('677966bb-7ab3-4e5a-8208-c1dde5d7fa5e', 'carmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Car Manager',
        'carmanager', '0606060608', 'ROLE_CAR_MANAGER', 'carmanager'),
       ('fe7213b9-6b46-4325-bb2d-33f9c64a98bf', 'hotelmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia',
        'Hotel Manager', 'hotelmanager', '0606060609', 'ROLE_HOTEL_MANAGER', 'hotelmanager'),
       ('f076f233-bf3e-49eb-ad94-d67b5bf95dbe', 'volmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Vol Manager',
        'volmanager', '0606060610', 'ROLE_VOL_MANAGER', 'volmanager');

INSERT INTO pays (id, nom)
VALUES ('France', 'France'),
       ('c63f4406-5485-47b7-a13c-443dea1de0bd', 'United States'),
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
       ('New York', 'New York', 'c63f4406-5485-47b7-a13c-443dea1de0bd'),  -- United States
       ('Tokyo', 'Tokyo', 'Japan'),  -- Japan
       ('Berlin', 'Berlin', 'Germany'),  -- Germany
       ('London', 'London', 'United Kingdom'),  -- United Kingdom
       ('Sydney', 'Sydney', 'Australia'),  -- Australia
       ('Rome', 'Rome', 'Italy'),  -- Italy
       ('Madrid', 'Madrid', 'Spain'),  -- Spain
       ('São Paulo', 'São Paulo', 'Brazil'),  -- Brazil
       ('Moscow', 'Moscow', 'Russia');  -- Russia

