CREATE TABLE jobRole (
    jobRoleID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    jobRoleName varchar(100) NOT NULL,
    jobRoleLocation ENUM ("BELFAST", "LONDON", "TORONTO", "BIRMINGHAM", "GDANSK"),
	capabiltyID smallint,
	bandID smallint,
	jobRoleClosingDate date NOT NULL,
	jobRoleOpen boolean,
    foreign key (capabiltyID) references capabilty(capabiltyID),
    foreign key (bandID) references band(bandID)

);
