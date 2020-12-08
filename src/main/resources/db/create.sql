SET MODE PostgreSQL;

CREATETABLE IF NOT EXISTS restaurants (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 zipcode VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);

CREATETABLE IF NOT EXISTS foodtypes (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATETABLE IF NOT EXISTS reviews (
 id int PRIMARY KEY auto_increment,
 writtenby VARCHAR,
 content VARCHAR,
 rating VARCHAR,
 restaurantid INTEGER
);
