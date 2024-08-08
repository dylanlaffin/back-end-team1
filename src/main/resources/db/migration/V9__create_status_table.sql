CREATE TABLE status(
StatusID TINYINT AUTO_INCREMENT NOT NULL,
Status varchar(32) NOT NULL,
PRIMARY KEY (StatusID)
);

INSERT INTO status(Status)
VALUES
("Hired"),
("Rejected"),
("In Progress");