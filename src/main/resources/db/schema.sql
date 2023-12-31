DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;


CREATE TABLE users
(
    id                      INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name                    VARCHAR(255)          NOT NULL,
    password                VARCHAR(255)          NOT NULL,
    email                   VARCHAR(255)          NOT NULL,
    restaurant_voted_id     INTEGER
);
-- CREATE UNIQUE INDEX email_unique_idx ON users (email);

CREATE TABLE roles
(
    role        VARCHAR(255)    NOT NULL,
    user_id     INTEGER         NOT NULL,
--     CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) references users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id                INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name              VARCHAR(255)          NOT NULL
);

CREATE TABLE dishes
(
    id                INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name              VARCHAR(255)          NOT NULL,
    price             DECIMAL(255)          NOT NULL,
    restaurant_id     INTEGER               NOT NULL,
    FOREIGN KEY (restaurant_id) references restaurants(id) ON DELETE CASCADE
);