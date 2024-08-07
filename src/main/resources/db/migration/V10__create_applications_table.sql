CREATE TABLE applications(
ApplicationID TINYINT AUTO_INCREMENT NOT NULL,
Username varchar(64) NOT NULL,
StatusID TINYINT NOT NULL,
ApplicationURL varchar(2048) NOT NULL,
PRIMARY KEY (ApplicationID),
FOREIGN KEY (Username) REFERENCES `User`(Username),
FOREIGN KEY (StatusID) REFERENCES status(StatusID)
);