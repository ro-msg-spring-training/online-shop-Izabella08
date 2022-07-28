CREATE TABLE IF NOT EXISTS `revenue` (
    `Id` INT PRIMARY KEY AUTO_INCREMENT,
    `Location` int NOT NULL REFERENCES location(id),
    `Date` datetime NOT NULL,
    `Sum` decimal(12,4) NOT NULL
    );
