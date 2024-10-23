INSERT INTO "role" ('id', 'nom')
VALUES  ('role1', 'ROLE_ADMIN'),
        ('role1', 'ROLE_USER'),
        ('role1', 'ROLE_CAR_MANAGER');

INSERT INTO "marque" ('id', 'nom')
VALUES  ('Marque1', 'Alpine');

INSERT INTO "modele_voiture" ('id', 'nom','nb_place', 'description', 'marque_id' )
VALUES  ('ModeleVoiture1', 'Alpine', 5, 'Je kiffe les Alpines', 'Marque1');

INSERT INTO "pays" ('id', 'nom')
VALUES  ('Pays1', 'France');
INSERT INTO "ville" ('id', 'nom','pays_id' )
VALUES  ('Ville1', 'Bonchamp', 'Pays1');

INSERT INTO "voiture" ('id', 'prix', 'modele_id', 'ville_id')
VALUES  ('role1', 5000, 'ModeleVoiture1','Ville1');
