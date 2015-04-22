TRUNCATE TABLE patient CASCADE;
INSERT INTO patient (patientid, name, bednr) VALUES (1, 'Paolo Rossi', 101);
INSERT INTO patient (patientid, name, bednr) VALUES (2, 'Barrack Obama', 102);
INSERT INTO patient (patientid, name, bednr) VALUES (3, 'Angela Merkel', 104);
INSERT INTO patient (patientid, name, bednr) VALUES (4, 'Mario Draghi', 203);
INSERT INTO patient (patientid, name, bednr) VALUES (5, 'Enrico Letta', 202);

TRUNCATE TABLE dish CASCADE;
INSERT INTO dish (dishid, name, price) VALUES (2, 'Lasagne', 2.20);
INSERT INTO dish (dishid, name, price) VALUES (3, 'Pasta al pomodoro', 1.20);
INSERT INTO dish (dishid, name, price) VALUES (4, 'Macedonia', 0.60);
INSERT INTO dish (dishid, name, price) VALUES (5, 'Bistecca di manzo', 3.30);
INSERT INTO dish (dishid, name, price) VALUES (6, 'Riso contorno', 0.30);
INSERT INTO dish (dishid, name, price) VALUES (7, 'Pane bianco', 0.10);
INSERT INTO dish (dishid, name, price) VALUES (1, 'Cotoletta di Maiale', 2.20);

TRUNCATE TABLE ingredient CASCADE;
INSERT INTO ingredient (ingredientid, name) VALUES (1, 'Carne di manzo');
INSERT INTO ingredient (ingredientid, name) VALUES (2, 'Semola di grano duro');
INSERT INTO ingredient (ingredientid, name) VALUES (3, 'Uova');
INSERT INTO ingredient (ingredientid, name) VALUES (4, 'riso');
INSERT INTO ingredient (ingredientid, name) VALUES (5, 'farina di grano tenero');
INSERT INTO ingredient (ingredientid, name) VALUES (6, 'pomodoro pelato');
INSERT INTO ingredient (ingredientid, name) VALUES (7, 'Carne di maiale');
INSERT INTO ingredient (ingredientid, name) VALUES (8, 'frutta');

TRUNCATE TABLE dishhasingredient CASCADE;
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (1, 7);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (2, 2);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (2, 3);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (2, 6);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (3, 2);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (3, 6);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (4, 8);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (5, 1);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (6, 4);
INSERT INTO dishhasingredient (dishid, ingredientid) VALUES (7, 5);



TRUNCATE TABLE ingredientprohibit CASCADE;
INSERT INTO ingredientprohibit(ingredientid, patientid) VALUES (5, 1);
INSERT INTO ingredientprohibit(ingredientid, patientid) VALUES (7, 2);
INSERT INTO ingredientprohibit(ingredientid, patientid) VALUES (6, 3);

TRUNCATE TABLE restriction CASCADE;
INSERT INTO restriction(restrictionid, name) VALUES (1, 'cumadin');
INSERT INTO restriction(restrictionid, name) VALUES (2, 'zoeliakie');

TRUNCATE TABLE dishassignedtorestriction CASCADE;
INSERT INTO dishassignedtorestriction(restrictionid, dishid) VALUES (2, 2);
INSERT INTO dishassignedtorestriction(restrictionid, dishid) VALUES (2, 3);
INSERT INTO dishassignedtorestriction(restrictionid, dishid) VALUES (2, 7);
INSERT INTO dishassignedtorestriction(restrictionid, dishid) VALUES (1, 4);

TRUNCATE TABLE patienthasrestriction CASCADE;
INSERT INTO patienthasrestriction(restrictionid, patientid) VALUES (1, 1);
INSERT INTO patienthasrestriction(restrictionid, patientid) VALUES (1, 2);
INSERT INTO patienthasrestriction(restrictionid, patientid) VALUES (2, 3);
INSERT INTO patienthasrestriction(restrictionid, patientid) VALUES (2, 4);

TRUNCATE TABLE employee CASCADE;
INSERT INTO employee(userid, name) VALUES ('curiem', 'Marie Curie');
INSERT INTO employee(userid, name) VALUES ('becquerelh', 'Henri Becquerel');
INSERT INTO employee(userid, name) VALUES ('einsteina', 'Albert Einstein');
INSERT INTO employee(userid, name) VALUES ('bohrn', 'Nils Bohr');
        
TRUNCATE TABLE delivery CASCADE;
INSERT INTO delivery VALUES (1, '2013-05-29', false);

TRUNCATE TABLE mealorder CASCADE;
INSERT INTO mealorder (orderid, patientid, userid, deliverynumber) VALUES (2, 1, 'einsteina', 1);
INSERT INTO mealorder (orderid, patientid, userid, deliverynumber) VALUES (3, 2, 'einsteina', 1);
INSERT INTO mealorder (orderid, patientid, userid, deliverynumber) VALUES (4, 3, 'einsteina', 1);
INSERT INTO mealorder (orderid, patientid, userid, deliverynumber) VALUES (5, 4, 'einsteina', 1);
INSERT INTO mealorder (orderid, patientid, userid, deliverynumber) VALUES (6, 5, 'einsteina', 1);


