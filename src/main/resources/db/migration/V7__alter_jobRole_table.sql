ALTER TABLE jobRole
ADD COLUMN jobRoleSpecUrl VARCHAR(2083) AFTER `jobRoleName`,
ADD COLUMN jobRoleResponsibilities text AFTER `jobRoleSpecUrl`,
ADD COLUMN jobRoleDescription text AFTER `jobRoleResponsibilities`;

INSERT into jobRole
(jobRoleName,jobRoleSpecUrl, jobRoleResponsibilities,
jobRoleDescription ,jobRoleLocation, capabiltyID, bandID, jobRoleClosingDate, jobRoleOpen)
values
("Technical Architect",
"https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Technical-Architect--Dynamics-365-_JR_14423",
"test responsibilities for the technical architect role", "test jd for the arch role", "TORONTO", 4, 2, "2024-08-21", true),
("Product Manager", "https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Product-Manager_JR_14352",
"test responsibilities for pm", "test description for PM job role","BELFAST", 4, 3, "2024-08-31", true),
("Sales Development Representative",
"https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Sales-Development-Representative---Workday_JR_14420",
"Test responsibilities for sales devel rep", "test description for sales dev rep", "BELFAST", 2, 1, "2024-09-02", true);