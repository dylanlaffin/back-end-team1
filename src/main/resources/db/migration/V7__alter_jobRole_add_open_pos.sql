ALTER TABLE jobRole ADD COLUMN numOpenPos INT DEFAULT 0;

INSERT INTO jobRole(jobRoleName, jobRoleLocation, capabiltyID, bandID, jobRoleClosingDate, jobRoleOpen, numOpenPos)
VALUES ("testJobName6","BELFAST",1,4,"2024-07-31", true, 1);