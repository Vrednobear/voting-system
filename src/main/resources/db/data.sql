DELETE FROM ROLES;
DELETE FROM USERS;
DELETE FROM RESTAURANTS;
DELETE FROM DISHES;

INSERT INTO USERS (id, name, password, email)
VALUES (1000,'User', 'userpassword','User@gmail.com'),
       (2000,'Admin', 'adminpassword','Admin@gmail.com');


INSERT INTO ROLES (role, user_id)
VALUES ('USER', 1000),
       ('ADMIN', 2000);

INSERT INTO RESTAURANTS (id, name)
VALUES (1000,'VESUVIO'),
       (2000,'GONG');

INSERT INTO DISHES (id,name, price, restaurant_id)
VALUES (1000,'Zitti', 12, 1000),
       (1001,'Prosciutto pizza', 15, 1000),
       (1002,'Tiramisu', 7, 1000),
       (1003,'Limonchello', 8, 1000);

INSERT INTO DISHES (id, name, price, restaurant_id)
VALUES (1004,'Chicken Teriyaki', 15, 2000),
       (1005,'Pad tai', 10, 2000),
       (1006,'Tom Kha', 15, 2000),
       (1007,'Sodju', 8, 2000);

-- SELECT * FROM USERS;
-- SELECT * FROM RESTAURANTS;
-- SELECT * FROM DISHES;
-- SELECT * FROM ROLES;

-- INSERT INTO USERS (NAME, EMAIL) VALUES ('Ton', 'TON1q@gmail.com');
