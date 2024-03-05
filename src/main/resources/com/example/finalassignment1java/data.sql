create database javaAssignment1;

use javaAssignment1;

CREATE TABLE CountryEmissions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    countryName VARCHAR(255) NOT NULL,
    region VARCHAR(255) NOT NULL,
    totalEmissions DECIMAL(5,2) NOT NULL
);
INSERT INTO CountryEmissions (countryName, region, totalEmissions) VALUES
('China', 'Asia', 30.9),
('U.S.', 'North America', 13.5),
('India', 'Asia', 7.3),
('Russia', 'Europe', 4.7),
('Japan', 'Asia', 2.9),
('Iran', 'Asia', 2.0),
('Germany', 'Europe', 1.8),
('Saudi Arabia', 'Other', 1.8),
('Indonesia', 'Asia', 1.7),
('South Korea', 'Asia', 1.7);