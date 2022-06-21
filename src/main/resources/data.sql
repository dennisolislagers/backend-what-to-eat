INSERT INTO users (id, username, password, emailadress) VALUES (1, 'ollie', 'sjuulke', 'dennis@hotmail.com');
INSERT INTO users (id, username, password, emailadress) VALUES (2, 'sjuulke', 'brokjes', 'sjuulke@hotmail.com');
INSERT INTO users (id, username, password, emailadress) VALUES (3, 'iris', 'lekkerslapen', 'iris@gmail.com');

INSERT INTO favourite (id, title, text, rating) VALUES (1, 'sajoer boontjes', 'ze smaken verukkelijk', 9);
INSERT INTO favourite (id, title, text, rating) VALUES (2, 'kippenvleugeltjes', 'heel erg pittig', 8);
INSERT INTO favourite (id, title, text, rating) VALUES (3, 'spek met eieren', 'erg lekker, maar niet goed voor de lijn', 9);

INSERT INTO menu (id, title, cuisine_type, health_label, diet_label, portions, calories, has_photo) VALUES (1, 'sajoer boontjes', 'dinner', 'balanced', 'fat-free', 4, 850, true);
INSERT INTO menu (id, title, cuisine_type, health_label, diet_label, portions, calories, has_photo) VALUES (2, 'kippenvleugeltjes', 'snack', 'koolhydraatarm', 'keto', 8, 630, true);
INSERT INTO menu (id, title, cuisine_type, health_label, diet_label, portions, calories, has_photo) VALUES (3, 'spek met eieren', 'breakfast', 'balanced', 'fishfree', 1, 490, true);

INSERT INTO ingredient (id, product_name, sort, amount) VALUES (1, 'tomatoes', 'vegetables', '4 pieces');
INSERT INTO ingredient (id, product_name, sort, amount) VALUES (2, 'potatoes', 'vegetables', '500 grams');
INSERT INTO ingredient (id, product_name, sort, amount) VALUES (3, 'eggs', 'n/a', '2 pieces');
INSERT INTO ingredient (id, product_name, sort, amount) VALUES (4, 'salt', 'spices', '1 theespoon');
INSERT INTO ingredient (id, product_name, sort, amount) VALUES (5, 'ribs', 'meat', '500 grams');

INSERT INTO newsletter (id, title, text, post_time) VALUES (1, 'nieuwsbrief week 1', 'deze week staat de italiaanse keuken centraal met als basis de zoete italiaanse tomaat', '2022-01-02');
INSERT INTO newsletter (id, title, text, post_time) VALUES (2, 'nieuwsbrief week 2', 'deze week speciale gerechten van restaurant de gouden balg uit utrecht', '2022-01-09');
INSERT INTO newsletter (id, title, text, post_time) VALUES (3, 'nieuwsbrief week 3', 'deze week tips over hoe je restjes uit de koelkast opmaakt', '2022-01-16');


INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (3, 5);
INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (2, 4);
INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (1, 1);
INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (1, 4);
INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (2, 3);
INSERT INTO menu_ingredient (menu_id, ingredient_id) VALUES (3, 2);