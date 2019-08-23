USE storefront;

#1. Identify the columns require indexing in order, product, category tables and create indexes.

ALTER TABLE product_category ADD INDEX index_parent_id(parent_id);
ALTER TABLE order_details ADD INDEX index_order_price(price);
ALTER TABLE product ADD INDEX index_issue_date(stock);

SHOW INDEX FROM product;

DROP INDEX index_issue_date ON product;
EXPLAIN SELECT * FROM product  WHERE stock = 10 ;
ALTER TABLE product ADD INDEX index_issue_date(stock);
EXPLAIN SELECT * FROM product  WHERE stock = 10 ;


-- DROP INDEX index_issue_date ON product;
-- DROP INDEX index_parent_id ON product_category;
-- DROP INDEX index_order_date ON order_details;

