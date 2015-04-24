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
        
TRUNCATE TABLE orders CASCADE;
INSERT INTO orders (orderid, orderdate, patientid) VALUES (1, '2013-05-29', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (2, '2013-05-29', 1);

TRUNCATE TABLE orderdetails CASCADE;
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (1, 1, 1);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (1, 2, 5);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 3, 1);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 4, 4);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 5, 3);


