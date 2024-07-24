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

INSERT into jobRole
(jobRoleName, jobRoleLocation, capabiltyID, bandID, jobRoleClosingDate, jobRoleOpen)
values
("testJobName1","BELFAST",1,4,"2024-07-31", true),
("testJobName2","BELFAST",3,1,"2024-07-31", false),
("testJobName3","TORONTO",3,2,"2024-07-31", true),
("testJobName4","BIRMINGHAM",4,2,"2024-08-15", true),
("testJobName5","GDANSK",2,1,"2024-07-15", false);