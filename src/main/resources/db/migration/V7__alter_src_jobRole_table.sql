ALTER TABLE jobRole
ADD COLUMN jobRoleSpecUrl VARCHAR(2083) AFTER `jobRoleName`,
ADD COLUMN jobRoleResponsibilities text AFTER `jobRoleSpecUrl`,
ADD COLUMN jobRoleDescription text AFTER `jobRoleResponsibilities`;