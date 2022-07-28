CREATE TABLE IF NOT EXISTS `stock` (
    `Product` int NOT NULL REFERENCES product(id),
    `Location` int NOT NULL REFERENCES location(id),
    `Quantity` int NOT NULL
);