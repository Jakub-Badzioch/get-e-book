CREATE TABLE USER (
  ID bigint NOT NULL AUTO_INCREMENT,
  LOGIN varchar(200) NOT NULL,
  PASSWORD varchar(200) NOT NULL,
  EMAIL varchar(200) UNIQUE NOT NULL,
  PRIMARY KEY (ID)
);
