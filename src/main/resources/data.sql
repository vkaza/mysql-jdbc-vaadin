DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
 id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

INSERT INTO customer(first_name, last_name) VALUES('Bruce', 'Tate');
INSERT INTO customer(first_name, last_name) VALUES('Mario', 'Fusco');
INSERT INTO customer(first_name, last_name) VALUES('Edson', 'Yanaga');
INSERT INTO customer(first_name, last_name) VALUES('Anton', 'Arhipov');
INSERT INTO customer(first_name, last_name) VALUES('Andres', 'Almiray');
