INSERT INTO reservacances.role (id, nom)
VALUES
    ('20a8120f-3e86-427c-85d5-7c8703cdea9a', 'ROLE_USER'),
    ('293afe03-43d6-4af6-adc3-2b051ae7573c', 'ROLE_ADMIN'),
    ('319efa5e-b95a-4c59-b72d-97388c02993e', 'ROLE_CAR_MANAGER'),
    ('48784d0d-c83e-456d-ab9a-db99b130d3a6', 'ROLE_HOTEL_MANAGER'),
    ('ec6e511a-c148-4035-af7f-832fb9726c02', 'ROLE_VOL_MANAGER');

INSERT INTO utilisateur (id, email, mot_de_passe, nom, prenom, telephone, role_id, username)
VALUES
    ('1235', 'admin@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Admin User', 'admin', '0606060607', '293afe03-43d6-4af6-adc3-2b051ae7573c', 'admin'),
    ('1236', 'carmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Car Manager', 'carmanager', '0606060608', '319efa5e-b95a-4c59-b72d-97388c02993e', 'carmanager'),
    ('1237', 'hotelmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Hotel Manager', 'hotelmanager', '0606060609', '48784d0d-c83e-456d-ab9a-db99b130d3a6', 'hotelmanager'),
    ('1238', 'volmanager@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'Vol Manager', 'volmanager', '0606060610', 'ec6e511a-c148-4035-af7f-832fb9726c02', 'volmanager');
