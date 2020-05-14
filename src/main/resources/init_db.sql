CREATE SCHEMA `internet_shop` ;
CREATE TABLE `internet_shop`.`products` (
  `product_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(225) NOT NULL,
  `product_price` DECIMAL(11) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) VISIBLE);
