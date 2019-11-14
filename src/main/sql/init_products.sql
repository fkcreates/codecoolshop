INSERT INTO product_category (id, name, description, department) VALUES (1, 'Guide to a successful PA', 'Essentials for your kitchen.', 'kitchen stuff');
SELECT pg_catalog.setval('product_category_id_seq', 2, true);

INSERT INTO supplier(name, description) VALUES ('Amazon2', 'They have everything you might need');
SELECT pg_catalog.setval('supplier_id_seq', 2, true);

INSERT INTO buyer VALUES (1, 'First User');
SELECT pg_catalog.setval('buyer_id_seq', 2, true);

INSERT INTO product VALUES (1, 'WORKBOOK', 'This is not your enemy. We advise you to fill it out on your own because you will learn a lot during the process.', 500, 'USD', 1, 1);
INSERT INTO product VALUES (2, 'PA practice', 'Kitchen mgmt, Network, Farm, Taxi.. you name it. Make the UML diagrams and implement the functions. Keep practicing.', 1500, 'USD', 1, 1);
INSERT INTO product VALUES (3, 'Peer consultation', 'Gather your peers and discuss pratices & questions you are unsure of. This will get you further in your studying process. Listen carefully and ask if you are lost.', 300, 'USD', 1, 1);
INSERT INTO product VALUES (4, 'Mentor consultation', 'Pay the price and learn from the wise.', 250, 'USD', 1, 1);
INSERT INTO product VALUES (5, 'Personal Assessment', 'Test your wisdom, use everything that you have learned on your journey. We wish you luck!', 2000, 'USD', 1, 1);
SELECT pg_catalog.setval('product_id_seq', 6, true);