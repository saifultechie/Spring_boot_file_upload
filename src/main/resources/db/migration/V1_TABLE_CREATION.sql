drop table if exists students
create table students(
student_id integer not null auto_increment,
student_name varchar(255),
student_age integer,
student_dept varchar(255),
student_dist varchar(255)
primary key student_id
);