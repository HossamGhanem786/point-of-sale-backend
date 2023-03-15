----------------------------------------------SUPPER_ADMIN------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO USERS (USERNAME,PASSWORD,ACTIVATED,CREATED_AT,CREADED_BY,UPDATED_AT,UPDATED_BY) VALUES ('hossam@g','$2a$10$KEiHy/EI.cScvE/jM2oVkuH4Hasslmv9GhplJ1Ec55zJ4NRjUbrYy',true,SYSDATE(),'admin',SYSDATE(),'admin');

---------------------------------------------------ROLE_LOOKUP--------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO ROLE (NAME,CREATED_AT,CREADED_BY,UPDATED_AT,UPDATED_BY)VALUES ('ROLE_ADMIN',SYSDATE(),'admin',SYSDATE(),'admin');
INSERT INTO ROLE (NAME,CREATED_AT,CREADED_BY,UPDATED_AT,UPDATED_BY)VALUES ('ROLE_USER',SYSDATE(),'admin',SYSDATE(),'admin');
---------------------------------------------------USERS_ROLES-----------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO users_roles (user_id,role_id) VALUES (1,1);




