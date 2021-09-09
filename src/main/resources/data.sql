use pizzeria;


-- Product table
INSERT INTO product (product_id, name, description, price) VALUES (1, "Cheese Slice", "A slice of cheese pizza", 2.99);
INSERT INTO product (product_id, name, description, price) VALUES (2, "Calzone", "Cheese calzone", 5.99);
INSERT INTO product (product_id, name, description, price) VALUES (3, "Ham Sandwich", "Basic Ham Sandwich", 4.99);
INSERT INTO product (product_id, name, description, price) VALUES (4, "Chicken Wings", "A bowl of chicken wings", 4.99);
INSERT INTO product (product_id, name, description, price) VALUES (5, "Chicken Parm", "A plate of Chicken Parmesan", 8.99);
INSERT INTO product (product_id, name, description, price) VALUES (6, "Cheese Pizza", "A 15-inch pie of cheese pizza", 9.99);
INSERT INTO product (product_id, name, description, price) VALUES (7, "Soda", "A bottle of soda", 1.99);
INSERT INTO product (product_id, name, description, price) VALUES (8, "Water", "A bottle of water", 1.99);

-- Addon table
INSERT INTO addon (addon_id, name, description, price) VALUES (1, "Pepperoni", "Pepperoni to add to product", .99);
INSERT INTO addon (addon_id, name, description, price) VALUES (2, "Meatball", "Meatablls to add to product", 1.99);
INSERT INTO addon (addon_id, name, description, price) VALUES (3, "Celery", "Celery to addd on as a side", 1.99);
INSERT INTO addon (addon_id, name, description, price) VALUES (4, "Fries", "Fries to add to product", 2.99);
INSERT INTO addon (addon_id, name, description, price) VALUES (5, "Sausage", "Sausage to add to product", 2.99);
INSERT INTO addon (addon_id, name, description, price) VALUES (6, "Mushroom", "Mushrooms to add to product", 1.99);