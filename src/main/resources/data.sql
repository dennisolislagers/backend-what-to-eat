INSERT INTO users (username, password, email, apikey, enabled)
 VALUES ('dennis', '$2a$12$UCRRvxXxgmQCu.ePVkh1RudePmxuamzxOK9rKiQyZ2snp.NaBdvmy','5DthG9pdr5T1kjhFRT2' ,'dennis@hotmail.com', TRUE),
        ('iris', '$2a$12$3OO.Q6jXqHVK1zJvAqEit.4k4En0Lf2bLadIZn4cd/kVl.XDSnAjC', '4kJld0vGT9T7KjhDsA3', 'iris@gmail.com', TRUE),
        ('sjuul', '$2a$12$RONwhcbHcBNZYUkYuglRNeuk7MKp6V0LpRsPNVd5FmUgHepYkTr6C', '3PLcg6lPF9T4PiUvFw7', 'sjuulke@hotmail.com', TRUE);


INSERT INTO menu (id, title, portions, calories, cuisine_type, meal_type, dish_type, vegan, peanut_allergy, cowmilk_allergy, gluten_allergy)
 VALUES (1001, 'sajoer boontjes', 4, 850, 'asian', 'dinner', 'side dish', TRUE, TRUE, TRUE, TRUE),
        (1002, 'kippenvleugeltjes', 8, 630, 'chinese', 'dinner', 'main dish', FALSE, FALSE, FALSE, FALSE),
        (1003, 'spek met eieren', 1, 490, 'british', 'breakfast', 'main dish', FALSE, TRUE, FALSE, FALSE);

INSERT INTO ingredient (id, food_id, quantity, measure, food_category)
 VALUES (1001, 'tomatoes', 1, 'pieces','vegetables'),
        (1002, 'potatoes', 500, 'grams', 'vegetables'),
        (1003, 'eggs', 2, 'pieces', 'diary'),
        (1004, 'salt', 1, 'teaspoon', 'spices'),
        (1005, 'ribs', 500, 'grams', 'meat');

INSERT INTO newsletter (id, title, text, post_time)
 VALUES (1001, 'nieuwsbrief week 1', 'Deze week staat de italiaanse keuken centraal met als basis de zoete italiaanse tomaat. De Italiaanse tomaat staat erom bekend dat hij lekker zoet en sapping is en dat je er veel verrassende gerechten mee kunt maken.'
                                    , '2022-01-02'),
        (1002, 'nieuwsbrief week 2', 'Deze week speciale gerechten van restaurant de gouden balg uit utrecht.' ||
                                  ' Deze week neemt chefkok Piet Brussels de tijd om speciale gerechten te maken'
                                    , '2022-01-09');

INSERT INTO menu_ingredient (menu_id, ingredient_id)
 VALUES (1003, 1005),
        (1002, 1004),
        (1001, 1001),
        (1001, 1004),
        (1002, 1003),
        (1003, 1002);

INSERT INTO authorities (username, authority)
VALUES  ('sjuul', 'ROLE_USER'),
        ('iris', 'ROLE_USER'),
        ('dennis', 'ROLE_ADMIN');

INSERT INTO label(id, type, web_label, api_parameter, definition)
VALUES  (1, 'Diet', 'Balanced', 'balanced', 'protein/fat/carb values in 15/35/50 ratio'),
        (2, 'Health', 'Celery-Free', 'celery-free', 'does not contain celery or deritavives'),
        (3, 'Diet', 'Low-Carb', 'low-carb', 'less than 20% of total calories from carbs'),
        (4, 'Health', 'Egg-Free', 'egg-free', 'No eggs or products containing eggs');

INSERT INTO photo (id, title, file_name, image_size, dimensions)
VALUES  (1, 'sajoer boontjes', 'saj_boo_12', 'small', '200x200'),
        (2, 'kippenvleugeltjes', 'kip_vle_456', 'thumbnail', '100x100'),
        (3, 'spek met eieren','spe_eie_786', 'large', '600x600');