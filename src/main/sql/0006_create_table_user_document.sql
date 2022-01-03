CREATE TABLE USER_DOCUMENT (
  ID bigint NOT NULL AUTO_INCREMENT,
  USER_ACCOUNT_ID bigint NOT NULL,
  DOCUMENT_ID bigint NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (USER_ACCOUNT_ID) REFERENCES USER_ACCOUNT(ID),
  FOREIGN KEY (DOCUMENT_ID) REFERENCES DOCUMENT(ID)
);
