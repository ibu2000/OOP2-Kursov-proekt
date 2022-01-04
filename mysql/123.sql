INSERT INTO status (idStatus, status)VALUES (1, 's1');
INSERT INTO status (idStatus, status)VALUES (2, 's2');
INSERT INTO status (idStatus, status)VALUES (3, 's3');
 
INSERT INTO usertype (idUserType, UserType)VALUES (1, 'type1');
INSERT INTO usertype (idUserType, UserType)VALUES (2, 'type2');
INSERT INTO usertype (idUserType, UserType)VALUES (3, 'type3');


INSERT INTO books (idBook, bookName, author, genre, yearOfPublishing)VALUES (1, 'bName1', 'author1', 'genre1', '2008-7-04');
INSERT INTO books (idBook, bookName, author, genre, yearOfPublishing)VALUES (2, 'bName2', 'author2', 'genre2', '2009-8-01');
INSERT INTO books (idBook, bookName, author, genre, yearOfPublishing)VALUES (3, 'bName3', 'author3', 'genre3', '2017-7-12');
 
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (1, 'u1', 'pas1','2017-7-12', 'good', 1,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (2, 'u2', 'pas2','2012-5-10', 'good', 2,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (3, 'u3', 'pas3','2018-1-11', 'good', 3,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (4, 'u4', 'pas4','2018-1-11', 'good', 1,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (5, 'u5', 'pas4','2018-1-11', 'good', 1,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (6, 'u6', 'pas4','2018-1-11', 'good', 1,2);
INSERT INTO user (idUser, userName, password, dateOfUserApproval, rating,USERTYPE_idUserType,STATUS_idStatus)VALUES (7, 'u7', 'pas4','2018-1-11', 'good', 1,2);
   
  
 INSERT INTO userinfo (idUser, name, phone, email)VALUES (1, 'name1', 'phone1', 'email1');
 INSERT INTO userinfo (idUser, name, phone, email)VALUES(2, 'ivo','001','abv');
INSERT INTO userinfo (idUser, name, phone, email)VALUES(3, 'teodora','002','gmail');
INSERT INTO userinfo (idUser, name, phone, email)VALUES(4, 'haki','003','bg');


INSERT INTO stateofbooks (idState, stateOfbooks)VALUES (1, 'new');
INSERT INTO stateofbooks (idState, stateOfbooks)VALUES (2, 'well preserved');
INSERT INTO stateofbooks (idState, stateOfbooks)VALUES (3, 'damaged');









