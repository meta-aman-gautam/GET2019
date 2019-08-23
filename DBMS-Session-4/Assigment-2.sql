
-- DROP PROCEDURE average_sales;
-- DROP PROCEDURE ordersOfTheGivenPeriod;

#1.Stored procedure to retrieve average sales of each product in a month
DELIMITER $$
CREATE PROCEDURE average_sales(month INT, year INT)
  BEGIN
      DECLARE total_order INT; 
      SELECT COUNT(*) INTO total_order
      FROM order_details o
      WHERE MONTH(o.date_ordered) = month AND YEAR(o.date_ordered) = year;

      SELECT o.cart_id,COUNT(*) / total_order AS average
      FROM order_details o
      WHERE MONTH(o.date_ordered) = month AND YEAR(o.date_ordered) = year
      GROUP BY o.cart_id;
  END $$
DELIMITER ;

CALL average_sales(08,2019);


#2.Stored procedure to retrieve table having order detail with status for a given period
DELIMITER $$
CREATE PROCEDURE ordersOfTheGivenPeriod(start_date DATE, end_date DATE)
   BEGIN
       IF start_date > end_date
           THEN SET start_date = DATE_ADD(DATE_ADD(LAST_DAY(end_date),INTERVAL 1 DAY),INTERVAL - 1 MONTH);
       END IF;
       SELECT p.product_name, p.price, o.total_price, o.order_status, o.date_ordered
       FROM product p, order_details o
       WHERE
           p.product_id = o.cart_id  AND
           o.date_ordered BETWEEN start_date AND end_date
       ORDER BY o.date_ordered DESC;
   END $$

CALL ordersOfTheGivenPeriod('2019-08-01','2019-08-09');