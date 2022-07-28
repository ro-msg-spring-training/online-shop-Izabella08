CREATE TABLE IF NOT EXISTS `product` (
    `Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` varchar(20) NOT NULL,
    `Description` varchar(100) NOT NULL,
    `Price` decimal(12,4) NOT NULL,
    `Weight` double NOT NULL,
    `Category` int NOT NULL REFERENCES productCategory(id),
    `Supplier` int NOT NULL REFERENCES supplier(id),
    `ImageUrl` varchar(256) NOT NULL
);