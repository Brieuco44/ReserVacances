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
