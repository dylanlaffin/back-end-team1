CREATE TABLE jobRole (
    jobRoleID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    jobRoleName varchar(100) NOT NULL,
    jobRoleLocation ENUM ("BELFAST", "LONDON", "TORONTO", "BIRMINGHAM", "GDANSK"),
	capabiltyID smallint,
	jobRoleBand varchar(100) NOT NULL,
	jobRoleClosingDate date NOT NULL,
	jobRoleOpen boolean,
    foreign key (capabiltyID) references capabilty(capabiltyID)
);

INSERT into jobRole
(jobRoleName, jobRoleLocation, capabiltyID, jobRoleBand, jobRoleClosingDate, jobRoleOpen)
values
("testJobName1","BELFAST",1,"Trainee","2024-07-31", true),
("testJobName2","BELFAST",3,"Associate","2024-07-31", false),
("testJobName3","TORONTO",3,"Senior Associate","2024-07-31", true),
("testJobName4","BIRMINGHAM",4,"Senior Associate","2024-08-15", true),
("testJobName5","GDANSK",2,"Associate","2024-07-15", false);