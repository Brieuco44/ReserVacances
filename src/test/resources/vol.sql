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

