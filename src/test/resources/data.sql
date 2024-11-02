INSERT INTO reservacances.role (id, nom)
VALUES ('20a8120f-3e86-427c-85d5-7c8703cdea9a', 'ROLE_USER'),
       ('293afe03-43d6-4af6-adc3-2b051ae7573c', 'ROLE_ADMIN'),
       ('319efa5e-b95a-4c59-b72d-97388c02993e', 'ROLE_CAR_MANAGER'),
       ('48784d0d-c83e-456d-ab9a-db99b130d3a6', 'ROLE_HOTEL_MANAGER'),
       ('ec6e511a-c148-4035-af7f-832fb9726c02', 'ROLE_VOL_MANAGER');

INSERT INTO utilisateur (id, email, mot_de_passe, nom, prenom, telephone, role_id, username)
VALUES ('fa064aa8-80de-439e-8ab7-28084e55985c', 'admin@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Admin User',
        'admin', '0606060607', '293afe03-43d6-4af6-adc3-2b051ae7573c', 'admin'),
       ('677966bb-7ab3-4e5a-8208-c1dde5d7fa5e', 'carmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Car Manager',
        'carmanager', '0606060608', '319efa5e-b95a-4c59-b72d-97388c02993e', 'carmanager'),
       ('fe7213b9-6b46-4325-bb2d-33f9c64a98bf', 'hotelmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia',
        'Hotel Manager', 'hotelmanager', '0606060609', '48784d0d-c83e-456d-ab9a-db99b130d3a6', 'hotelmanager'),
       ('f076f233-bf3e-49eb-ad94-d67b5bf95dbe', 'volmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Vol Manager',
        'volmanager', '0606060610', 'ec6e511a-c148-4035-af7f-832fb9726c02', 'volmanager');

INSERT INTO pays (id, nom)
VALUES ('cb227084-0bd5-4402-942f-169d00e0997b', 'France'),
       ('c63f4406-5485-47b7-a13c-443dea1de0bd', 'United States'),
       ('2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4', 'Japan'),
       ('3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1', 'Germany'),
       ('4bfa2c9e-1485-4a52-9c6c-88132fcd0496', 'United Kingdom'),
       ('f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8', 'Australia'),
       ('ea0eaf12-30d2-4f61-9a04-b6342c4a1c42', 'Italy'),
       ('c71f73bc-650c-43d5-a6ef-9167658eb5b9', 'Spain'),
       ('9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d', 'Brazil'),
       ('6632f78e-4a7b-4205-bc68-182ea25bc59b', 'Russia');

INSERT INTO ville (id, nom, pays_id)
VALUES ('cb227084-0bd5-4402-942f-169d00e0998b', 'Paris', 'cb227084-0bd5-4402-942f-169d00e0997b'),  -- France
       ('c63f4406-5485-47b7-a13c-443dea1de1bd', 'New York', 'c63f4406-5485-47b7-a13c-443dea1de0bd'),  -- United States
       ('2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4', 'Tokyo', '2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4'),  -- Japan
       ('3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1', 'Berlin', '3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1'),  -- Germany
       ('4bfa2c9e-1485-4a52-9c6c-88132fcd0496', 'London', '4bfa2c9e-1485-4a52-9c6c-88132fcd0496'),  -- United Kingdom
       ('f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8', 'Sydney', 'f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8'),  -- Australia
       ('ea0eaf12-30d2-4f61-9a04-b6342c4a1c42', 'Rome', 'ea0eaf12-30d2-4f61-9a04-b6342c4a1c42'),  -- Italy
       ('c71f73bc-650c-43d5-a6ef-9167658eb5b9', 'Madrid', '4bfa2c9e-1485-4a52-9c6c-88132fcd0496'),  -- Spain
       ('9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d', 'São Paulo', '9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d'),  -- Brazil
       ('6632f78e-4a7b-4205-bc68-182ea25bc59b', 'Moscow', '6632f78e-4a7b-4205-bc68-182ea25bc59b');  -- Russia

