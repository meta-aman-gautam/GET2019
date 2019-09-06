create database inventoryDetails ;

CREATE TABLE inventory(
itemname VARCHAR (30),
itemquantity INT
);

INSERT into inventory(itemname,itemquantity) VALUES
('apple',6),
('grapes',9),
('banana',12);



drop table inventory;


select * from inventory ;

SET SAFE_UPDATE = TRUE ;

update inventory 
set 
itemname = "banana" and
itemquantity = 2;

