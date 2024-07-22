CREATE TABLE `User`(
Username varchar(64) NOT NULL,
Password char(60) NOT NULL,
RoleID TINYINT NOT NULL,
PRIMARY KEY (Username),
FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);

INSERT INTO `User`(Username, Password, RoleID) VALUES("admin", "$2a$10$0fVhElli6zf/AkCt03J2W.0LoQRnl9CR/iY2Pu38LymHqOspE0bha", 1);
INSERT INTO `User`(Username, Password, RoleID) VALUES("user", "$2a$10$aGs2jdxL1nyvAPj9D8Z8IOuLaEF.Fr5L9LVp9C33YFgX6fDN1RBK6", 2);