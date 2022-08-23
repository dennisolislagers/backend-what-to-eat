INSERT INTO users (username, password, email, enabled)
 VALUES ('dennis', '$2a$12$UCRRvxXxgmQCu.ePVkh1RudePmxuamzxOK9rKiQyZ2snp.NaBdvmy', 'dennis@hotmail.com', TRUE)
        ('iris', '$2a$12$3OO.Q6jXqHVK1zJvAqEit.4k4En0Lf2bLadIZn4cd/kVl.XDSnAjC', 'iris@gmail.com', TRUE);
        ('sjuul', '$2a$12$RONwhcbHcBNZYUkYuglRNeuk7MKp6V0LpRsPNVd5FmUgHepYkTr6C', 'sjuulke@hotmail.com', TRUE),


INSERT INTO menu (id, title, portions, calories, peanut_allergy, cowmilk_allergy, gluten_allergy)
 VALUES (1, 'sajoer boontjes', 4, 850, TRUE, TRUE, TRUE),
        (2, 'kippenvleugeltjes', 8, 630, FALSE, FALSE, FALSE),
        (3, 'spek met eieren', 1, 490, FALSE, FALSE);

INSERT INTO ingredient (id, food_id, quantity, measure, weight, food, food_category)
 VALUES (1, 'tomatoes', 1, 'pieces', 1, 'vegetables', 'greengrocer' ),
        (2, 'potatoes', 500, 'grams' , 500, 'vegetables', 'greengrocer'),
        (3, 'eggs', 2, 'pieces', 2, 'diary', 'versmarkt'),
        (4, 'salt', 1, 'theespoon'),
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
VALUES  ('sjuulke', 'ROLE_USER'),
        ('iris', 'ROLE_USER'),
        ('ollie', 'ROLE_ADMIN');