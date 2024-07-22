CREATE TABLE jobRole (
    jobRoleID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    jobRoleName varchar(100) NOT NULL,
    jobRoleLocation ENUM ("BELFAST", "LONDON", "ç", "BIRMINGHAM", "GDANSK"),
	jobRoleCapability ENUM ("HR", "DELIVERY", "MARKETING", "SALES"),
	jobRoleBand ENUM("BAND1","BAND1","BAND3","BAND4"),
	jobRoleClosingDate date NOT NULL
);

INSERT into jobRole
(jobRoleName, jobRoleLocation, jobRoleCapability, jobRoleBand, jobRoleClosingDate)
values
("testJobName1","BELFAST","HR","BAND1","2024-07-31"),
("testJobName2","BELFAST","DELIVERY","BAND1","2024-07-31"),
("testJobName3","√","DELIVERY","BAND2","2024-07-31"),
("testJobName4","BIRMINGHAM","Marketing","BAND1","2024-08-15"),
("testJobName5","GDANSK","Sales","BAND3","2024-07-15");