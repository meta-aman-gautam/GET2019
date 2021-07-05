use store_front ;

#Q1  With respect to StoreFront application identify, apply and list the constraints you would apply on the columns for the tables created.


CREATE TABLE user_details (
user_id INT NOT NULL AUTO_INCREMENT,
password varchar(12) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE shopper (
shopper_id INT NOT NULL,
shopper_name varchar(20) NOT NULL,
mobile BIGINT (10) NOT NULL,
FOREIGN KEY (shopper_id) REFERENCES user_details(user_id)
);

CREATE TABLE admin_details (
admin_id INT ,
admin_name VARCHAR(20) NOT NULL ,
email VARCHAR(30) NOT NULL ,
FOREIGN KEY (admin_id) REFERENCES user_details(user_id)
);

CREATE TABLE shopper_address (
shopper_id INT,
address VARCHAR(50) NOT NULL,
FOREIGN KEY (shopper_id) REFERENCES user_details(user_id)
);

CREATE TABLE category(
category_id INT AUTO_INCREMENT,
category_name VARCHAR(20) NOT NULL ,
parent_id INT ,
parent_category VARCHAR(20),
PRIMARY key (category_id)
);

CREATE TABLE product(
product_id INT AUTO_INCREMENT,
product_name VARCHAR(20) NOT NULL ,
price FLOAT(2) NOT NULL,
stock INT NOT NULL ,
date_added DATETIME ,
category_id INT,
isactive BOOLEAN ,
PRIMARY KEY (product_id) ,
FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE cart(
cart_id INT ,
product_id INT ,
quantity INT NOT NULL ,
price FLOAT NOT NULL ,
date_added DATETIME NOT NULL,
item_status VARCHAR(10) ,
FOREIGN KEY (cart_id) REFERENCES user_details(user_id) ,
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE order_details(
order_id INT NOT NULL AUTO_INCREMENT,
cart_id INT ,
address VARCHAR(50) NOT NULL REFERENCES shopper_address(address),
date_ordered DATETIME NOT NULL ,
total_price INT NOT NULL,
order_status VARCHAR(20) NOT NULL,
PRIMARY KEY (order_id) ,
FOREIGN KEY (cart_id) REFERENCES cart(cart_id) 
);

CREATE TABLE images(
product_id INT ,
image_src VARCHAR(50) ,
FOREIGN KEY (product_id) REFERENCES product(product_id)
);
CREATE TABLE product(
product_id INT AUTO_INCREMENT,
product_name VARCHAR(20) NOT NULL ,
price FLOAT(2) NOT NULL,
stock INT NOT NULL ,
date_added DATETIME ,
category_id INT,
isactive BOOLEAN ,
PRIMARY KEY (product_id) ,
FOREIGN KEY (category_id) REFERENCES category(category_id)
);


