INSERT INTO modele_avion (id, nb_place, nom)
VALUES ('4a8f91e6-5670-44f6-a469-341fa9d65c3d', 350, 'Airbus A380'),
       ('5b9a27f7-6781-4af9-8f0a-4d8a6c77c8e1', 180, 'Boeing 737'),
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
        'cb227084-0bd5-4402-942f-169d00e0997b'), -- Paris, France
       ('92b12348-8bc9-4e67-b3be-36af95bcfc9c', 'Aéroport de Los Angeles International (LAX)',
        'c63f4406-5485-47b7-a13c-443dea1de0bd'), -- Los Angeles, USA
       ('efb83dc7-b2b6-4f55-8bff-5f162c5a8b90', 'Aéroport international de Narita',
        '2e6d8f2b-4c1c-4bc3-ae63-7e06243a54b4'), -- Tokyo, Japan
       ('55c09f11-f96c-44d5-a2c1-6c7a9bc27b27', 'Aéroport de Francfort',
        '3c87c432-dc29-4abf-bbcb-b7cdb3a4d1b1'), -- Francfort, Allemagne
       ('e1d51b5f-84f4-4d82-a423-51c0986edfe7', 'Aéroport de Heathrow',
        '4bfa2c9e-1485-4a52-9c6c-88132fcd0496'), -- Londres, Royaume-Uni
       ('eb403f79-efc3-41c5-9105-929aa15c7206', 'Aéroport de Sydney',
        'f16f8ef3-bb49-4e90-a6ee-02b3d4f2f0c8'), -- Sydney, Australie
       ('4a7e4b91-1bfa-4a3f-9302-cf5801dc644b', 'Aéroport de Rome-Fiumicino',
        'ea0eaf12-30d2-4f61-9a04-b6342c4a1c42'), -- Rome, Italie
       ('50be837e-cab2-48e8-8951-26ed2cb289c9', 'Aéroport Adolfo Suárez Madrid-Barajas',
        'c71f73bc-650c-43d5-a6ef-9167658eb5b9'), -- Madrid, Espagne
       ('456f4f29-f322-4649-b2a0-80ee4cb0c367', 'Aéroport international de São Paulo-Guarulhos',
        '9e1cb3b0-8b8a-4489-8aa8-0b0a0b2aab5d'), -- São Paulo, Brésil
       ('c7e5b07f-6b66-4042-a574-3e295b7eac8c', 'Aéroport international de Sheremetyevo',
        '6632f78e-4a7b-4205-bc68-182ea25bc59b'); -- Moscou, Russie


INSERT INTO compagnie (id, nom)
VALUES ('a26cb918-3d9c-49c8-9c79-3cde3eab0b6f', 'Lufthansa'),
       ('b37dc029-4eac-4ad8-9d7a-4def4fbc1c7d', 'Air France'),
       ('c48ed13a-5fbd-4be8-9e7b-5efg5gdc2d8e', 'EasyJet'),
       ('d59fe24b-6gce-4cf8-9f7c-6fgh6hde3e9f', 'Ryanair'),
       ('e60gf35c-7hdg-4dg8-9g7d-7gih7idf4f0g', 'British Airways'),
       ('f71gh46d-8ieh-4eh8-9h7e-8hih8jeg5g1h', 'KLM Royal Dutch Airlines'),
       ('g82hi57e-9jfi-4fi8-9i7f-9ijh9kfh6h2i', 'Emirates'),
       ('h93ij68f-0kgj-4gj8-9j7g-0jki0lgi7i3j', 'Qatar Airways');

INSERT INTO reservacances.modele_avion (id, nb_place, nom)
VALUES ('4a8f91e6-5670-44f6-a469-341fa9d65c3d', 350, 'A380'),            -- Airbus A380
       ('dca5c614-63e6-4df1-a6a5-604256d78f35', 200, 'A320'),            -- Airbus A320
       ('7d5e504c-5fa1-4978-b8c5-8c5c2c129a2f', 250, 'Boeing 737'),      -- Boeing 737
       ('b3cbe71c-d61e-4a14-a09b-63774b3d1a11', 300, 'Boeing 787'),      -- Boeing 787
       ('36c0c25f-505b-473e-b7ee-7169c44c7aa4', 400, 'Boeing 777'),      -- Boeing 777
       ('d1a4e7f2-d849-4e1f-8e01-b1a1f70c1d61', 180, 'Embraer E195'),    -- Embraer E195
       ('8b3fbc77-e6cf-4f3b-b8de-d8a7214aa1f2', 100, 'Bombardier Q400'), -- Bombardier Q400
       ('e7dfb300-8b7b-4665-bfbb-798ab2b7a2f4', 50, 'Cessna 172'); -- Cessna 172


INSERT INTO reservacances.avion (id, compagnie_id, modele_avion_id)
VALUES ('1c6e3f30-02bc-4d44-87ef-f9f1a9c9a9e5', 'a26cb918-3d9c-49c8-9c79-3cde3eab0b6f',
        '4a8f91e6-5670-44f6-a469-341fa9d65c3d'), -- Lufthansa A380
       ('2d6f4c30-58ab-4d44-97f1-e9e5f9e3a2f0', 'b37dc029-4eac-4ad8-9d7a-4def4fbc1c7d',
        'dca5c614-63e6-4df1-a6a5-604256d78f35'), -- Air France A320
       ('3e7g5d40-6eaf-4c5e-a7f4-c0f4b5d6e3f1', 'c48ed13a-5fbd-4be8-9e7b-5efg5gdc2d8e',
        '7d5e504c-5fa1-4978-b8c5-8c5c2c129a2f'), -- EasyJet Boeing 737
       ('4f8h6e50-7fbc-4d6f-b7e5-d1f5c6e7f4a2', 'd59fe24b-6gce-4cf8-9f7c-6fgh6hde3e9f',
        'b3cbe71c-d61e-4a14-a09b-63774b3d1a11'), -- Ryanair Boeing 787
       ('5g9i7f60-8fcd-4e7f-c8f6-e2g6d7f8e5a3', 'e60gf35c-7hdg-4dg8-9g7d-7gih7idf4f0g',
        '36c0c25f-505b-473e-b7ee-7169c44c7aa4'), -- British Airways Boeing 777
       ('6h0j8g70-9gef-4f8g-d9g7-f3h7e8g9f6b4', 'f71gh46d-8ieh-4eh8-9h7e-8hih8jeg5g1h',
        'd1a4e7f2-d849-4e1f-8e01-b1a1f70c1d61'), -- KLM Royal Dutch Airlines Embraer E195
       ('7i1k9h80-0hfg-4g9h-e0h8-g4i8h9g0h7c5', 'g82hi57e-9jfi-4fi8-9i7f-9ijh9kfh6h2i',
        '8b3fbc77-e6cf-4f3b-b8de-d8a7214aa1f2'), -- Emirates Bombardier Q400
       ('8j2l0i90-1hgf-5h0i-f1i9-h5j9k0i1j8d6', 'h93ij68f-0kgj-4gj8-9j7g-0jki0lgi7i3j',
        'e7dfb300-8b7b-4665-bfbb-798ab2b7a2f4'); -- Qatar Airways Cessna 172

INSERT INTO reservacances.vol ( id, date_debut, date_fin, prix_adulte, prix_enfant, aeroport_depart_id
                              , aeroport_arrivee_id
                              , avion_id)
VALUES ('1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 100.0, 50.0,
        '3b7b2e63-e9a0-4a5c-b6f6-1f2bb4938a84', '92b12348-8bc9-4e67-b3be-36af95bcfc9c',
        '1c6e3f30-02bc-4d44-87ef-f9f1a9c9a9e5'), -- Paris -> Los Angeles
       ('2b3c4d5e-6f7g-8h9i-0j1k-2l3m4n5o6p', '2024-10-02 22:48:01', '2024-10-03 10:47:32', 150.0, 75.0,
        '92b12348-8bc9-4e67-b3be-36af95bcfc9c', '3b7b2e63-e9a0-4a5c-b6f6-1f2bb4938a84',
        '2d6f4c30-58ab-4d44-97f1-e9e5f9e3a2f0'), -- Los Angeles -> Paris
       ('3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 200.0, 100.0,
        'efb83dc7-b2b6-4f55-8bff-5f162c5a8b90', '55c09f11-f96c-44d5-a2c1-6c7a9bc27b27',
        '3e7g5d40-6eaf-4c5e-a7f4-c0f4b5d6e3f1'), -- Tokyo -> Francfort
       ('4d5e6f7g-8h9i-0j1k-2l3m-4n5o6p7q8r', '2024-10-02 22:48:01', '2024-10-03 10:47:32', 250.0, 125.0,
        '55c09f11-f96c-44d5-a2c1-6c7a9bc27b27', 'efb83dc7-b2b6-4f55-8bff-5f162c5a8b90',
        '4f8h6e50-7fbc-4d6f-b7e5-d1f5c6e7f4a2'), -- Francfort -> Tokyo
       ('5e6f7g8h-9i0j-1k2l-3m4n-5o6p7q8r9s', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 300.0, 150.0,
        'e1d51b5f-84f4-4d82-a423-51c0986edfe7', 'eb403f79-efc3-41c5-9105-929aa15c7206',
        '5g9i7f60-8fcd-4e7f-c8f6-e2g6d7f8e5a3'), -- Londres -> Sydney
       ('6f7g8h9i-0j1k-2l3m-4n5o-6p7q8r9s0t', '2024-10-02 22:48:01', '2024-10-03 10:47:32', 350.0, 175.0,
        'eb403f79-efc3-41c5-9105-929aa15c7206', 'e1d51b5f-84f4-4d82-a423-51c0986edfe7',
        '6h0j8g70-9gef-4f8g-d9g7-f3h7e8g9f6b4'), -- Sydney -> Londres
       ('7g8h9i0j-1k2l-3m4n-5o6p-7q8r9s0t1u', '2024-10-02 10:47:32', '2024-10-02 22:48:01', 400.0, 200.0,
        '4a7e4b91-1bfa-4a3f-9302-cf5801dc644b', '50be837e-cab2-48e8-8951-26ed2cb289c9',
        '7i1k9h80-0hfg-4g9h-e0h8-g4i8h9g0h7c5'), -- Rome -> Madrid
       ('8h9i0j1k-2l3m-4n5o-6p7q-8r9s0t1u2v', '2024-10-02 22:48:01', '2024-10-03 10:47:32', 450.0, 225.0,
        '50be837e-cab2-48e8-8951-26ed2cb289c9', '4a7e4b91-1bfa-4a3f-9302-cf5801dc644b',
        '8j2l0i90-1hgf-5h0i-f1i9-h5j9k0i1j8d6'); -- Madrid -> Rome

INSERT INTO reservation_vol (id, nb_adulte, nb_enfant, utilisateur_id, vol_id)
VALUES ('1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o', 4, 2, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o'), -- Paris -> Los Angeles
       ('2b3c4d5e-6f7g-8h9i-0j1k-2l3m4n5o6p', 2, 1, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '2b3c4d5e-6f7g-8h9i-0j1k-2l3m4n5o6p'), -- Los Angeles -> Paris
       ('3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q', 3, 1, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q'), -- Tokyo -> Francfort
       ('4d5e6f7g-8h9i-0j1k-2l3m-4n5o6p7q8r', 1, 1, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '4d5e6f7g-8h9i-0j1k-2l3m-4n5o6p7q8r'), -- Francfort -> Tokyo
       ('5e6f7g8h-9i0j-1k2l-3m4n-5o6p7q8r9s', 2, 1, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '5e6f7g8h-9i0j-1k2l-3m4n-5o6p7q8r9s'), -- Londres -> Sydney
         ('6f7g8h9i-0j1k-2l3m-4n5o-6p7q8r9s0t', 3, 2, 'fa064aa8-80de-439e-8ab7-28084e55985c',
        '6f7g8h9i-0j1k-2l3m-4n5o-6p7q8r9s0t'); -- Sydney -> Londres

