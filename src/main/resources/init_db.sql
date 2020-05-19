CREATE TABLE `order_products`
(
    `order_id`   bigint DEFAULT NULL,
    `product_id` bigint DEFAULT NULL,
    KEY `order_id_idx` (`order_id`),
    KEY `product_id_idx` (`product_id`),
    CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `orders`
(
    `order_id` bigint NOT NULL AUTO_INCREMENT,
    `user_id`  bigint DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    KEY `orders_user_fk_idx` (`user_id`),
    CONSTRAINT `orders_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `products`
(
    `product_id` bigint         NOT NULL AUTO_INCREMENT,
    `name`       varchar(225)   NOT NULL,
    `price`      decimal(11, 0) NOT NULL,
    PRIMARY KEY (`product_id`),
    UNIQUE KEY `product_name_UNIQUE` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 42
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `roles`
(
    `role_id`   bigint       NOT NULL AUTO_INCREMENT,
    `role_name` varchar(256) NOT NULL,
    PRIMARY KEY (`role_id`),
    UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `shopping_carts`
(
    `card_id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint DEFAULT NULL,
    PRIMARY KEY (`card_id`),
    KEY `user_id_idx` (`user_id`),
    CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `shopping_carts_products`
(
    `card_id`    bigint DEFAULT NULL,
    `product_id` bigint DEFAULT NULL,
    KEY `cart_id_idx` (`card_id`),
    KEY `product_id_idx` (`product_id`),
    CONSTRAINT `card_id` FOREIGN KEY (`card_id`) REFERENCES `shopping_carts` (`card_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `products_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `users`
(
    `user_id`  bigint         NOT NULL AUTO_INCREMENT,
    `name`     varchar(256)   NOT NULL,
    `login`    varchar(256)   NOT NULL,
    `password` varchar(256)   NOT NULL,
    `salt`     varbinary(256) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 27
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `users_roles`
(
    `user_id` bigint DEFAULT NULL,
    `role_id` bigint DEFAULT NULL,
    KEY `user_id_idx` (`user_id`),
    KEY `role_id_idx` (`role_id`),
    CONSTRAINT `roles_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
