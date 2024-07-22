CREATE TABLE jobRole (
    jobRoleID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    jobRoleName varchar(100) NOT NULL,
    jobRoleLocation ENUM ("Belfast", "London", "Toronto", "Birmingham", "Gdansk"),
	jobRoleCapability ENUM ("HR", "Delivery", "Marketing", "Sales"),
	jobRoleBand ENUM("20,000-30,000","30,001-36,000","36,001-42,000","42,001-60,000"),
	jobRoleClosingDate date NOT NULL
);

INSERT into jobRole
(jobRoleName, jobRoleLocation, jobRoleCapability, jobRoleBand, jobRoleClosingDate)
values
("testJobName1","Belfast","HR","20,000-30,000","2024-07-31"),
("testJobName2","Belfast","Delivery","20,000-30,000","2024-07-31"),
("testJobName3","Toronto","Delivery","30,001-36,000","2024-07-31"),
("testJobName4","Birmingham","Marketing","20,000-30,000","2024-08-15"),
("testJobName5","Gdansk","Sales","36,001-42,000","2024-07-15");