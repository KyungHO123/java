CREATE DATABASE IF NOT EXISTS university1;
# 정경호

create table if not exists student(
	st_num varchar(15) primary key unique, #학생번호
	st_name varchar(5) not null,	#학생이름
	st_major varchar(10) not null, 	#학생전공
	st_grade int not null	#학생 학년
);
create table if not exists professor(
	pr_num varchar(15) primary key unique, #교번
    pr_name varchar(5) not null,	#교수명
    pr_room varchar(10)not null,	#교수실
    pr_major varchar(10)not null	#전공
);
create table if not exists lecture(
	le_num	varchar(15) primary key unique,#강의번호
    le_title varchar(10) ,#강의명
    le_room varchar(10) not null,#강의실 
    le_schedule int not null,#강의시간
    le_point int not null,#학점
    le_time int not null,#시수
    le_pr_num varchar(15)#교번

);
create table if not exists course(
	co_num varchar(15) primary key unique, #수강번호
    co_st_num varchar(15) not null,#학번
    co_le_num varchar(15) not null#강의번호
);
create table if not exists contact(
	ct_st_num varchar(15) primary key unique,# 학번 
    ct_phone varchar(11) not null,# 전화번호
    ct_addr varchar(30) not null,#주소
    ct_detail varchar(50) not null#상세주소

);