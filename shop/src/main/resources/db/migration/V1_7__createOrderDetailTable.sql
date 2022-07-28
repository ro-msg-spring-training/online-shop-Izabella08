CREATE TABLE IF NOT EXISTS `orderDetail` (
    `Order` int NOT NULL REFERENCES order_product(id),
    `Product` int NOT NULL REFERENCES product(id),
    `Quantity` int NOT NULL
    );