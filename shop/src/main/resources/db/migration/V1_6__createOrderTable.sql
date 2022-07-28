CREATE TABLE IF NOT EXISTS `order_product` (
    `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ShippedFrom` int NOT NULL REFERENCES location(id),
    `Customer` int NOT NULL REFERENCES customer(id),
    `CreatedAt`  datetime NOT NULL,
    `Country` varchar(50) NOT NULL,
    `City` varchar(50) NOT NULL,
    `County` varchar(50) NOT NULL,
    `StreetAddress` VARCHAR(50) NOT NULL
    );

