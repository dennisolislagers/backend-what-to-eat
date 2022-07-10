INSERT INTO users (username, password, email, enabled)
 VALUES ('ollie', '$2a$12$w/HpVBHuWixcUMRL3yAuxekpAmBYwEkz6b0HXmJFM8MUazLKCVhYe', 'dennis@hotmail.com', true),
        ('sjuulke', '$2a$12$4EXX0nIwYjNcGcr5BVZ1heBUi3AX2wFvioyFxkdy/D5IC1u/n84o6', 'sjuulke@hotmail.com', true),
        ('iris', '$2a$12$npvmBuoLq4VoC0cgcM1ZzeSv73TtxJwleXme2/ghNDnSLTfShH.F2', 'iris@gmail.com', true);

INSERT INTO favourite (id, title, text, rating)
 VALUES (1, 'sajoer boontjes', 'ze smaken verukkelijk', 9),
        (2, 'kippenvleugeltjes', 'heel erg pittig', 8),
        (3, 'spek met eieren', 'erg lekker, maar niet goed voor de lijn', 9);

INSERT INTO menu (id, title, cuisine_type, health_label, diet_label, portions, calories, has_photo)
 VALUES (1, 'sajoer boontjes', 'dinner', 'balanced', 'fat-free', 4, 850, true),
        (2, 'kippenvleugeltjes', 'snack', 'koolhydraatarm', 'keto', 8, 630, true),
        (3, 'spek met eieren', 'breakfast', 'balanced', 'fishfree', 1, 490, true);

INSERT INTO ingredient (id, product_name, sort, amount)
 VALUES (1, 'tomatoes', 'vegetables', '4 pieces'),
        (2, 'potatoes', 'vegetables', '500 grams'),
        (3, 'eggs', 'n/a', '2 pieces'),
        (4, 'salt', 'spices', '1 theespoon'),
        (5, 'ribs', 'meat', '500 grams');

INSERT INTO newsletter (id, title, text, post_time)
 VALUES (1, 'nieuwsbrief week 1', 'Deze week staat de italiaanse keuken centraal met als basis de zoete italiaanse tomaat. De Italiaanse tomaat staat erom bekend dat hij lekker zoet en sapping is en dat je er veel verrassende gerechten mee kunt maken.'
                                    , '2022-01-02'),
        (2, 'nieuwsbrief week 2', 'Deze week speciale gerechten van restaurant de gouden balg uit utrecht.' ||
                                  ' Deze week neemt chefkok Piet Brussels de tijd om speciale gerechten te maken'
                                    , '2022-01-09');


INSERT INTO menu_ingredient (menu_id, ingredient_id)
 VALUES (3, 5),
        (2, 4),
        (1, 1),
        (1, 4),
        (2, 3),
        (3, 2);

INSERT INTO authorities (username, authority)
VALUES ('sjuulke', 'USER'),
       ('iris', 'USER'),
        ('ollie', 'ADMIN');