INSERT INTO course (id, name, created_date, last_updated_date)
VALUES (10001, 'JPA in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO course (id, name, created_date, last_updated_date)
VALUES (10002, 'Spring in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO course (id, name, created_date, last_updated_date)
VALUES (10003, 'ivnajln in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);





insert into passport(id, number)
values(40001, 'E123456');
insert into passport(id, number)
values(40002, 'N123457');
insert into passport(id, number)
values(40003, 'L123493');





insert into student(id, name, passport_id)
values(20001, 'Ranga', 40001);
insert into student(id, name, passport_id)
values(20002, 'Adam', 40002);
insert into student(id, name, passport_id)
values(20003, 'Jane', 40003);







insert into review(id, rating, description, course_id)
values(50001, '5', 'Great course', 10001);
insert into review(id, rating, description, course_id)
values(50002, '4', 'Wonderful course', 10001);
insert into review(id, rating, description, course_id)
values(50003, '5', 'Awesome as always', 10003);

insert into student_course(student_id, course_id)
values(20001,10001);
insert into student_course(student_id, course_id)
values(20002,10001);
insert into student_course(student_id, course_id)
values(20003,10001);
insert into student_course(student_id, course_id)
values(20001,10003);