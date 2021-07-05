#1. Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

SELECT * FROM order_details ;

DELIMITER $$
CREATE FUNCTION calculateOrders(month INT , year INT) RETURNS INT
    BEGIN 
        DECLARE count INT ;
        SELECT COUNT(order_id) INTO count FROM order_details 
        WHERE MONTH(date_ordered)=MONTH AND  YEAR(date_ordered)=YEAR
        GROUP BY MONTH(date_ordered);
        RETURN count;
    END$$
   DELIMITER ; 

SELECT CALCULATEORDERS(08,2019);


#2.  Create a function to return month in a year having maximum orders. Year will be input parameter.
  
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION calculateMaximumOrders(year INT) RETURNS INT
       BEGIN
           DECLARE month_of_max_orders INT;
           SELECT MONTH(o.date_ordered) INTO month_of_max_orders
           FROM order_details o
           WHERE YEAR(o.date_ordered) = year
           ORDER BY MONTH(o.date_ordered) DESC
           LIMIT 1;
           RETURN (month_of_max_orders);
       END$$
DELIMITER ;

SELECT CALCULATEMAXIMUMORDERS(2019);