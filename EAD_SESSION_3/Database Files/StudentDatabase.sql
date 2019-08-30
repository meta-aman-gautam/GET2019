show databases ;
create database Student ;
use student ;

drop table studentdetails;

create table studentdetails (
studentid INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
firstname varchar(20) ,
lastname varchar(20),
fathername varchar(20),
email varchar(50) UNIQUE NOT NULL, 
class INT,
age Int
);

truncate studentdetails;
INSERT into studentdetails (firstname,lastname,fathername,email,class,age) VALUES
('Ajay','Kumar','Mahesh Kumar','ajggkumar@gmail.com',10,22),
('Prateek','Jain','Mr Jain','gjajkumar@gmail.com',12,22),
('aman','gautam','Ravindra Kumar','aman.gautam@metacube.com',11,22),
('Prateek','Jain','Mr Jain','prateek.jain@gmail.com',12,22);


select * from studentdetails ;




