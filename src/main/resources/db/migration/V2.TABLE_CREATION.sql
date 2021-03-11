drop table if exists files
create table files(
id integer not null auto_increment,
file_name varchar(255),
file_type varchar(255)
primary key id
);