TRUNCATE TABLE patient CASCADE;
INSERT INTO patient (patientid, name, bednr) VALUES (1, 'Yanis Varoufakis', 101);
INSERT INTO patient (patientid, name, bednr) VALUES (2, 'Barrack Obama', 102);
INSERT INTO patient (patientid, name, bednr) VALUES (3, 'Angela Merkel', 104);
INSERT INTO patient (patientid, name, bednr) VALUES (4, 'Vladimir Putin', 203);
INSERT INTO patient (patientid, name, bednr) VALUES (5, 'Matteo Renzi', 202);

TRUNCATE TABLE dish CASCADE;
INSERT INTO dish (dishid, name, price) VALUES (1, 'Cotoletta di Maiale', 2.20);
INSERT INTO dish (dishid, name, price) VALUES (2, 'Lasagne', 2.20);
INSERT INTO dish (dishid, name, price) VALUES (3, 'Pasta al pomodoro', 1.20);
INSERT INTO dish (dishid, name, price) VALUES (4, 'Macedonia', 0.60);
INSERT INTO dish (dishid, name, price) VALUES (5, 'Bistecca di manzo', 3.30);
INSERT INTO dish (dishid, name, price) VALUES (6, 'Riso contorno', 0.30);
INSERT INTO dish (dishid, name, price) VALUES (7, 'Pane bianco', 0.10);
INSERT INTO dish (dishid, name, price) VALUES (8, 'Pane di Kamut', 0.20);
INSERT INTO dish (dishid, name, price) VALUES (9, 'Minestra di verdure', 1.10);
INSERT INTO dish (dishid, name, price) VALUES (10, 'Risotto asparagi', 3.10);
INSERT INTO dish (dishid, name, price) VALUES (11, 'Risotto milanese', 3.10);
INSERT INTO dish (dishid, name, price) VALUES (12, 'Verdure lesse', 3.10);
INSERT INTO dish (dishid, name, price) VALUES (13, 'Polenta pasticciata', 1.10);
INSERT INTO dish (dishid, name, price) VALUES (14, 'Gnocchi al pomodoro', 2.10);
INSERT INTO dish (dishid, name, price) VALUES (15, 'Carciofi alla romana', 2.00);

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
INSERT INTO orders (orderid, orderdate, patientid) VALUES (1, '2015-04-29', 1);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (2, '2015-04-29', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (3, '2015-04-29', 3);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (4, '2015-04-30', 1);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (5, '2015-04-30', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (6, '2015-04-30', 3);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (7, '2015-05-01', 1);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (8, '2015-05-01', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (9, '2015-05-01', 3);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (10, '2015-05-02', 1);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (11, '2015-05-02', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (12, '2015-05-02', 3);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (13, '2015-05-02', 4);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (14, '2015-05-03', 1);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (15, '2015-05-03', 2);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (16, '2015-05-03', 3);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (17, '2015-05-03', 4);
INSERT INTO orders (orderid, orderdate, patientid) VALUES (18, '2015-05-03', 5);

TRUNCATE TABLE orderdetails CASCADE;
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (1, 1, 2);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (1, 2, 4);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 3, 1);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 4, 5);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (2, 5, 5);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (8, 15, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (8, 5, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (8, 4, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (4, 2, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (4, 5, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (4, 6, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (4, 4, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (3, 1, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (3, 12, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (7, 3, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (7, 6, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (7, 5, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (13, 15, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (13, 1, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (13, 12, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (10, 2, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (10, 4, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (10, 5, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (14, 13, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (14, 14, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (14, 7, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (5, 9, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (5, 12, 0);
INSERT INTO orderdetails (orderid, dishid, rating) VALUES (5, 6, 0);


