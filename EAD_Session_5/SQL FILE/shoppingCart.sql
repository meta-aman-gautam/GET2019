
create database shoppingCart ;
use shoppingCart ;
set foreign_key_checks =0;
drop table product;

-- product table , cart table  -use table


create table users (
userid INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
email VARCHAR(50),
password VARCHAR(20)
);

create table product (
productid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
productname VARCHAR(20) ,
price FLOAT(10),
producttype VARCHAR(30)
);

create table cart(
cartid INT NOT NULL,
productid INT,
productquantity INT,
FOREIGN KEY(cartid) REFERENCES users(userid),
FOREIGN KEY(productid) REFERENCES product(productid)
);



INSERT into users(email,password) VALUES
('aman','1234'),
('harsh','2345'),
('ankit','3456');




INSERT into product (productid,productname,price,producttype) VALUES
(1,'ladyfinger',50,'vegetable'),
(2,'RealMe',5000,'Mobile'),
(3,'USB Cable',500,'Accessories');

INSERT into cart (cartid,productid,productquantity) VALUES
(1,1,4),
(2,1,6),
(1,2,8),
(2,3,9),
(3,2,5);