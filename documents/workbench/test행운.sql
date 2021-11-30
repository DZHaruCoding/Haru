-- 행운
select * from user;
select * from project;
select * from userproject;
select * from file;

insert into project values(1,"프로젝트 생성 1","프로젝트 내용 입니다.",now(),now()+7,'T',now());
insert into project values(2,"프로젝트 생성 2","프로젝트 2 내용 입니다.",now(),now()+30,'T',now());
insert into userproject values(1,1,'O');
insert into userproject values(1,2,'M');

-- 파일
insert into file values(1,17,"test","test","/file/path",now(),"T","이종윤" );
select task_no, file_no, origin_name, change_name, file_path, file_regdate, file_state, file_maker from file;

