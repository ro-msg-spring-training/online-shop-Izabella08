CREATE TABLE IF NOT EXISTS `customer` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` varchar(20) NOT NULL,
    `last_name` varchar(20) NOT NULL,
    `username` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    `email_address` varchar(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `supplier` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `product_category` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20) NOT NULL,
    `description` varchar(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `product` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20) NOT NULL,
    `description` varchar(100) NOT NULL,
    `price` decimal(12,4) NOT NULL,
    `weight` double NOT NULL,
    `category` int NOT NULL REFERENCES product_category(id),
    `supplier` int NOT NULL REFERENCES supplier(id),
    `image_url` varchar(256) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `location` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20) NOT NULL,
    `address_country` varchar(50) NOT NULL,
    `address_city` varchar(50) NOT NULL,
    `address_county` varchar(50) NOT NULL,
    `address_street_address` varchar(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `stock` (
    `product` int NOT NULL REFERENCES product(id),
    `location` int NOT NULL REFERENCES location(id),
    `quantity` int NOT NULL,
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY
    );

CREATE TABLE IF NOT EXISTS `order_product` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `shipped_from` int NOT NULL REFERENCES location(id),
    `customer` int NOT NULL REFERENCES customer(id),
    `created_at`  datetime NOT NULL,
    `address_country` varchar(50) NOT NULL,
    `address_city` varchar(50) NOT NULL,
    `address_county` varchar(50) NOT NULL,
    `address_street_address` VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `order_detail` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `orderp` int NOT NULL REFERENCES order_product(id),
    `product` int NOT NULL REFERENCES product(id),
    `quantity` int NOT NULL
    );




