DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq AS INTEGER START WITH 100000;

//add indexes and constr

CREATE TABLE users
(
    id                INTEGER DEFAULT NEXTVAL('global_seq') PRIMARY KEY,
    name              VARCHAR(255)          NOT NULL,
    email             VARCHAR(255)          NOT NULL,
    restaurantVotedId INTEGER
);
CREATE UNIQUE INDEX email_unique_idx ON users (email);

CREATE TABLE roles
(
    role VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) references users(id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id                INTEGER DEFAULT NEXTVAL('global_seq') PRIMARY KEY,
    name              VARCHAR(255)          NOT NULL
);

CREATE TABLE dishes
(
    id                INTEGER DEFAULT NEXTVAL('global_seq') PRIMARY KEY,
    name              VARCHAR(255)          NOT NULL,
    price             VARCHAR(255)          NOT NULL,
    restaurant_id     INTEGER               NOT NULL,
    FOREIGN KEY (restaurant_id) references restaurants(id) ON DELETE CASCADE
);