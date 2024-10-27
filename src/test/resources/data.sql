INSERT INTO role (id, nom) VALUES ('20a8120f-3e86-427c-85d5-7c8703cdea9a', 'ROLE_USER');
INSERT INTO role (id, nom) VALUES ('293afe03-43d6-4af6-adc3-2b051ae7573c', 'ROLE_ADMIN');
INSERT INTO role (id, nom) VALUES ('319efa5e-b95a-4c59-b72d-97388c02993e', 'ROLE_CAR_MANAGER');




INSERT INTO "utilisateur" (id, email, mot_de_passe, nom, prenom,telephone,role_id,username)
VALUES
    ('user1', 'test@gmail.com', '$2a$10$ymmS9V9dtHTqCVIBmxs7s.J27iR1NvfOJY1b2BaOGN86NY6Ov9yia', 'User 1', 'user1','0606060606','','user1'),