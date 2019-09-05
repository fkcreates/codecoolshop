INSERT INTO product_category (id, name, description, department) VALUES (1, 'Kitchen Mgmt', 'Essentials for your kitchen.', 'kitchen stuff');
SELECT pg_catalog.setval('product_category_id_seq', 2, true);

INSERT INTO supplier(name, description) VALUES ('Amazon2', 'They have everything you might need');
SELECT pg_catalog.setval('supplier_id_seq', 2, true);

INSERT INTO buyer VALUES (1, 'First User');
SELECT pg_catalog.setval('buyer_id_seq', 2, true);

INSERT INTO product VALUES (1, 'Awesome cocktail glass', 'The curviest glass youve ever seen.', 35, 'USD', 1, 1);
INSERT INTO product VALUES (2, 'Forkest fork', 'Pure silver fork that picks up any food you want it to. Simply the best.', 144, 'USD', 1, 1);
INSERT INTO product VALUES (3, 'Pure plate', 'A very simple and elegant plate. Serve your dinner, lunch or even breakfast in it. You wont be disappointed, we promise.', 25, 'USD', 1, 1);
INSERT INTO product VALUES (4, 'Bamboo cutlery', 'Cutlery set made of bamboo. Please take care of the environment so our children can live long. Even though Pandas die so we can make these. No worries, they look cool.', 48, 'USD', 1, 1);
INSERT INTO product VALUES (5, 'Set of knives and forks', 'This set contains 4 butter knives and 4 forks. Theyll look like youve inherited them from your great-grandma. But we know its just a mainstream deal.', 300, 'USD', 1, 1);
SELECT pg_catalog.setval('product_id_seq', 6, true);