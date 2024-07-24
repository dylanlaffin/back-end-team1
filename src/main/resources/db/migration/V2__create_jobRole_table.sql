CREATE TABLE jobRole (
    jobRoleID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    jobRoleName varchar(100) NOT NULL,
    jobRoleLocation ENUM ("BELFAST", "LONDON", "TORONTO", "BIRMINGHAM", "GDANSK"),
	jobRoleCapability ENUM ("HR", "DELIVERY", "MARKETING", "SALES"),
	jobRoleBand ENUM("BAND1","BAND2","BAND3","BAND4"),
	jobRoleClosingDate date NOT NULL,
	jobRoleOpen boolean
);

INSERT into jobRole
(jobRoleName, jobRoleLocation, jobRoleCapability, jobRoleBand, jobRoleClosingDate, jobRoleOpen)
values
("testJobName1","BELFAST","HR","BAND1","2024-07-31", true),
("testJobName2","BELFAST","DELIVERY","BAND1","2024-07-31", false),
("testJobName3","TORONTO","DELIVERY","BAND2","2024-07-31", true),
("testJobName4","BIRMINGHAM","Marketing","BAND1","2024-08-15", true),
("testJobName5","GDANSK","Sales","BAND3","2024-07-15", false);