DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (ID INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
                       NAME VARCHAR(255), SALARY BIGINT, PRIMARY KEY (ID));

