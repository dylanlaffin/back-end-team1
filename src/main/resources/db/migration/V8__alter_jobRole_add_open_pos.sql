ALTER TABLE jobRole ADD COLUMN numOpenPos INT DEFAULT 0;

INSERT into jobRole
(jobRoleName,jobRoleSpecUrl, jobRoleResponsibilities,
jobRoleDescription ,jobRoleLocation, capabiltyID, bandID, jobRoleClosingDate, jobRoleOpen, numOpenPos)
values
("Workday Financials Solution Architect",
"https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Workday-Financials-Solution-Architect_JR_14301",
"test responsibilities for the solutions arc role", "test jd for the solutions arc role", "BELFAST", 4, 2, "2024-08-21", true, 1);