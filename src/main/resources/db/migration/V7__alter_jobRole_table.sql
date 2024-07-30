ALTER TABLE jobRole
ADD COLUMN jobRoleSpecification TEXT AFTER `jobRoleName`;

INSERT into jobRole
(jobRoleName, jobRoleSpecification, jobRoleLocation, capabiltyID, bandID, jobRoleClosingDate, jobRoleOpen)
values
("Technical Architect",
"test Responsibilities for the technical artchitect role test jd for teh arch role https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Technical-Architect--Dynamics-365-_JR_14423" , "TORONTO", 4, 2, "2024-08-21", true),
("Product Manager",
"test Responsibilities for pm. Test description for PM job role https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Product-Manager_JR_14352","BELFAST", 4, 3, "2024-08-31", true),
("Sales Development Representative",
"Test responsibilities for sales devel rep. Test description for sales dev rep. https://kainos.wd3.myworkdayjobs.com/en-US/Kainos/details/Sales-Development-Representative---Workday_JR_14420", "BELFAST", 2, 1, "2024-09-02", true);