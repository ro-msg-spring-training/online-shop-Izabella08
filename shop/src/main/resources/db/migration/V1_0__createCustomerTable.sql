CREATE TABLE IF NOT EXISTS `customer` (
    `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `FirstName` varchar(20) NOT NULL,
    `LastName` varchar(20) NOT NULL,
    `Username` varchar(20) NOT NULL,
    `Password` varchar(20) NOT NULL,
    `EmailAddress` varchar(20) NOT NULL
);

