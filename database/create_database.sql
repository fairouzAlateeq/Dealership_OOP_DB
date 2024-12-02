DROP DATABASE IF EXISTS dealerships;

CREATE DATABASE IF NOT EXISTS dealerships;

USE dealerships;

# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

create table `dealership` (
`dealership_id` int auto_increment primary key,
`name` varchar(50 ) not null,
`address` varchar(50),
`phone` varchar(12)
);

create table `vehicle` (
`vin` int not null auto_increment,
`year` int,
`make` varchar(50),
`model` varchar(50),
`vehicle_type` varchar(50),
`color` varchar(50),
`odometer` int,
`price` double,
`dealership_id` int,
`sold` boolean,
CONSTRAINT `pk_vehicle_vin` PRIMARY KEY (`vin`),
FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id)
);