CREATE TABLE capabilty (
    capabiltyID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    capabilityName varchar(100) NOT NULL);

INSERT into capabilty
(capabilityName)
values
("HR"),
("Sales"),
("Marketing"),
("Delivery");