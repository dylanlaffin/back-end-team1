CREATE TABLE band (
    bandID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    bandName varchar(100) NOT NULL);

INSERT into band
(bandName)
values
("Associate"),
("Senior Associate"),
("Manager"),
("Trainee");