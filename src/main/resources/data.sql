insert into classTeacher(id,firstName, lastName,email, password,phoneNumber,myWorkingDays,parentsContact)values(1,'Liz','Trass','lizztrass@gmail.com','Passpass_12', 0499423397,'Mon-Tue-Thu-Fr','Every 3 months');

CREATE SEQUENCE mySequence MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 20 NOMAXVALUE;


/*CREATE SEQUENCE mySequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;*/


insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Jens','Kwak','jens@mail.com','password',13,'Boy','2AC',1);
insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Valerie','Smith','smith@net.com','pass',13,'Girl','2AC',1);
insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Elise','Buynder','elise@yahoo.com','pass',12,'Girl','2AC',1);
insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Jan','Lemberg','jan@mail.be','1234',13,'Boy','2AC',1);
insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Bob','Claus','bob@hotmail.com','password',13,'Boy','2AC',1);

insert into student (id,firstName,lastName,email, password,age,gender,grade,classTeacher_id)values(nextval('mySequence'),'Student','STUDENT','student@hotmail.com','password',13,'Boy','2AC',1);


alter sequence mySequence RESTART WITH 6;
alter sequence userSequence RESTART WITH 6;
alter sequence userSequence increment by 1;



insert into results (id,maxPoint,subjects,remarks,student_id) values (1,60.0,'HISTORY','fair',1);
insert into results (id,maxPoint,subjects,remarks,student_id) values (2,75.0,'HISTORY','good',2);
insert into results (id,maxPoint,subjects,remarks,student_id) values (3,90.0,'HISTORY','very good',3);
insert into results (id,maxPoint,subjects,remarks,student_id)values (4,98.0,'HISTORY','awesome',4);
insert into results (id,maxPoint,subjects,remarks,student_id)values (5,60.00,'HISTORY','fair',5);

insert into results (id,maxPoint,subjects,remarks,student_id)values (6,62.0,'INFORMATICS','fair',1);
insert into results (id,maxPoint,subjects,remarks,student_id)values (7,32.0,'INFORMATICS','retest',2);
insert into results (id,maxPoint,subjects,remarks,student_id) values (8,55.0,'INFORMATICS','retest',3);
insert into results (id,maxPoint,subjects,remarks,student_id)values (9,98.0,'INFORMATICS','awesome',4);
insert into results (id,maxPoint,subjects,remarks,student_id)values (10,60.00,'INFORMATICS','fair',5);


insert into results (id,maxPoint,subjects,remarks,student_id)values (11,98.0,'GEOGRAPHY','awesome',1);
insert into results (id,maxPoint,subjects,remarks,student_id)values (12,79.0,'GEOGRAPHY','very good',2);
insert into results (id,maxPoint,subjects,remarks,student_id) values (13,58.0,'GEOGRAPHY','fair',3);
insert into results (id,maxPoint,subjects,remarks,student_id)values (14,98.0,'GEOGRAPHY','awesome',4);
insert into results (id,maxPoint,subjects,remarks,student_id)values (15,60.00,'GEOGRAPHY','fair',5);

insert into results (id,maxPoint,subjects,remarks,student_id)values (16,98.0,'ECONOMY','awesome',1);
insert into results (id,maxPoint,subjects,remarks,student_id)values (17,60.00,'ECONOMY','fair',2);
insert into results (id,maxPoint,subjects,remarks,student_id)values (18,98.0,'ECONOMY','awesome',3);
insert into results (id,maxPoint,subjects,remarks,student_id)values (19,60.00,'ECONOMY','fair',4);
insert into results (id,maxPoint,subjects,remarks,student_id)values (20,98.0,'ECONOMY','awesome',5);


insert into parent(id,firstName, lastName, email, password,relation,student_id)values(1,'Hella','Buynder','hella@mail.com','123','mother',3);
insert into parent(id,firstName, lastName, email, password,relation,student_id)values(2,'Jan','Kwak','kwak@proximus.be','123','father',1);
insert into parent(id,firstName, lastName, email, password,relation,student_id)values(3,'Pieter','Lemberg','lemberg@telenet.be','123','father',4);
insert into parent(id,firstName, lastName, email, password,relation,student_id)values(4,'Els','Smith','els@hotmail.com','123','mother',2);
insert into parent(id,firstName, lastName, email, password,relation,student_id)values(5,'Sofie','Sel','sel@belgacom.be','123','mother',5);

