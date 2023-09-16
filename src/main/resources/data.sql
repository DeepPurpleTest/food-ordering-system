-- cuisine
INSERT INTO cuisine (name) VALUES ('Polish');
INSERT INTO cuisine (name) VALUES ('Mexican');
INSERT INTO cuisine (name) VALUES ('Italian');

-- meal
INSERT INTO meal (name, price) VALUES ('meal1', 1000);
INSERT INTO meal (name, price) VALUES ('meal2', 2000);
INSERT INTO meal (name, price) VALUES ('meal3', 3000);

-- dessert
INSERT INTO dessert (name, price) VALUES ('dessert1', 500);
INSERT INTO dessert (name, price) VALUES ('dessert2', 600);
INSERT INTO dessert (name, price) VALUES ('dessert3', 700);

-- lunch
INSERT INTO lunch (name, cuisine_id, meal_id, dessert_id) VALUES ('lunch1',1, 1, 1);
INSERT INTO lunch (name, cuisine_id, meal_id, dessert_id) VALUES ('lunch2',2, 2, 2);
INSERT INTO lunch (name, cuisine_id, meal_id, dessert_id) VALUES ('lunch3',3, 3, 3);

-- drink
INSERT INTO drink (name, price) VALUES ('drink1', 150);
INSERT INTO drink (name, price) VALUES ('drink2', 250);
INSERT INTO drink (name, price) VALUES ('drink3', 350);

-- addition
INSERT INTO addition (lemon, ice) VALUES (false, false);
INSERT INTO addition (lemon, ice) VALUES (false, true);
INSERT INTO addition (lemon, ice) VALUES (true, true);

-- drink_addition
INSERT INTO drink_addition (drink_id, addition_id) VALUES (1, 1);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (1, 2);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (1, 3);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (2, 1);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (2, 2);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (2, 3);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (3, 1);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (3, 2);
INSERT INTO drink_addition (drink_id, addition_id) VALUES (3, 3);