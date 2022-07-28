CREATE TABLE IF NOT EXISTS `location` (
    `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` varchar(20) NOT NULL,
    `Country` varchar(50) NOT NULL,
    `City` varchar(50) NOT NULL,
    `County` varchar(50) NOT NULL,
    `StreetAddress` varchar(50) NOT NULL
);