CREATE SCHEMA `internet_shop`;
CREATE TABLE `internet_shop`.`products`
(
    `product_id`    BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `product_name`  VARCHAR(225) NOT NULL,
    `product_price` DECIMAL(11)  NOT NULL,
    PRIMARY KEY (`product_id`),
    UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) VISIBLE
);
CREATE TABLE `internet_shop`.`users`
(
    `user_id`  BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(256) NOT NULL,
    `login`    VARCHAR(256) NOT NULL,
    `password` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE
);
CREATE TABLE `internet_shop`.`orders`
(
    `order_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `user_id`  BIGINT(11) NULL,
    PRIMARY KEY (`order_id`),
    INDEX `orders_user_fk_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `orders_user_fk`
        FOREIGN KEY (`user_id`)
            REFERENCES `internet_shop`.`users` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE TABLE `internet_shop`.`roles`
(
    `role_id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`role_id`),
    UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC) VISIBLE
);
CREATE TABLE `internet_shop`.`shopping_carts`
(
    `card_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT(11) NULL,
    PRIMARY KEY (`card_id`),
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `internet_shop`.`users` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE TABLE `internet_shop`.`order_products`
(
    `order_id`   BIGINT(11) NULL,
    `product_id` BIGINT(11) NULL,
    INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
    INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `order_id`
        FOREIGN KEY (`order_id`)
            REFERENCES `internet_shop`.`orders` (`order_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `product_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `internet_shop`.`products` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE TABLE `internet_shop`.`shopping_carts_products`
(
    `card_id`    BIGINT(11) NULL,
    `product_id` BIGINT(11) NULL,
    INDEX `cart_id_idx` (`card_id` ASC) VISIBLE,
    INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `card_id`
        FOREIGN KEY (`card_id`)
            REFERENCES `internet_shop`.`shopping_carts` (`card_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `products_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `internet_shop`.`products` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE TABLE `internet_shop`.`users_roles`
(
    `user_id` BIGINT(11) NULL,
    `role_id` BIGINT(11) NULL,
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
    CONSTRAINT `users_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `internet_shop`.`users` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `roles_id`
        FOREIGN KEY (`role_id`)
            REFERENCES `internet_shop`.`roles` (`role_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
ALTER TABLE `internet_shop`.`users_roles`
    DROP FOREIGN KEY `roles_id`,
    DROP FOREIGN KEY `users_id`;
ALTER TABLE `internet_shop`.`users_roles`
    ADD CONSTRAINT `roles_id`
        FOREIGN KEY (`role_id`)
            REFERENCES `internet_shop`.`roles` (`role_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `users_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `internet_shop`.`users` (`user_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;
ALTER TABLE `internet_shop`.`order_products`
    DROP FOREIGN KEY `order_id`,
    DROP FOREIGN KEY `product_id`;
ALTER TABLE `internet_shop`.`order_products`
    ADD CONSTRAINT `order_id`
        FOREIGN KEY (`order_id`)
            REFERENCES `internet_shop`.`orders` (`order_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `product_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `internet_shop`.`products` (`product_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

INSERT INTO roles(role_name) VALUES ("USER");
INSERT INTO roles(role_name) VALUES ("ADMIN");
