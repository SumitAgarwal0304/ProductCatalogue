CREATE TABLE Product_Type(
	id  integer auto_increment NOT NULL PRIMARY KEY,
	product_type_name varchar,
	product_type_desc varchar
);


CREATE TABLE Product(
	id    integer auto_increment NOT NULL PRIMARY KEY,
	product_name  varchar,
	product_type_id integer,
	product_price  double precision
);