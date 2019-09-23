use employee_data;

DROP TABLE friend;
DROP TABLE plan_details;
DROP TABLE vehicle_details;
DROP TABLE employee_details;


CREATE TABLE employee_details (
employee_id INT AUTO_INCREMENT PRIMARY KEY,
fullname VARCHAR(200) NOT NULL,
gender VARCHAR(10) CHECK (gender IN ('Male','Female')),
email VARCHAR(200) NOT NULL UNIQUE,
password VARCHAR(200) NOT NULL,
contact_number BIGINT NOT NULL,
organization ENUM('Metacube','TCS','Wipro','Voylla') NOT NULL
);

CREATE TABLE vehicle_details (
employee_id INT,
vehicle_name VARCHAR(200) NOT NULL,
type VARCHAR(20) CHECK (type IN ('Cycle','MotorCycle','Four Wheelers')),
vechile_number VARCHAR(200) PRIMARY KEY,
identification VARCHAR(200),
FOREIGN KEY(employee_id) REFERENCES employee_details(employee_id) ON DELETE SET NULL
);



CREATE TABLE plan_details (
    employee_id INT,
    vechile_number VARCHAR(200),
    plan VARCHAR(20) CHECK ( plan IN ('daily','monthly','yearly')),
    price INT NOT NULL,
    FOREIGN KEY(vechile_number) REFERENCES vehicle_details(vechile_number) ON DELETE SET NULL,
    FOREIGN KEY(employee_id) REFERENCES employee_details(employee_id) ON DELETE SET NULL    
);



CREATE TABLE friend(
employee_id INT,
organization VARCHAR(200) REFERENCES employee_details(organization) ON DELETE SET NULL,
FOREIGN KEY(employee_id) REFERENCES employee_details(employee_id) ON DELETE SET NULL
);

              
    