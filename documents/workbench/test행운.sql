-- 행운
select * from user;
select * from project;
select * from userproject;
select * from file;

-- 프로젝트

insert into project values(1,"프로젝트 생성 1","프로젝트 내용 입니다.",now(),now()+7,'T',now());
insert into project values(2,"프로젝트 생성 2","프로젝트 2 내용 입니다.",now(),now()+30,'T',now());
insert into userproject values(1,1,'O');
insert into userproject values(1,2,'M');



-- 파일
insert into file values(1,17,"test","test","/file/path",now(),"T","이종윤" );
select task_no, file_no, origin_name, change_name, file_path, file_regdate, file_state, file_maker from file;
select * from userproject as up join project as p on up.project_no = p.project_no where up.user_no = 1;

-- 프로젝트
select *
from userproject as up join user as u on up.user_no = u.user_no
join project as p on up.project_no = p.project_no
where up.user_no = 1;

select up.user_no as userNo, 
	   u.user_name as userName, 
       u.user_photo as userPhoto, 
       up.project_no as projectNo, 
       p.project_title as projectTitle, 
       p.project_desc as projectDesc, 
       date_format(p.project_start, '%Y-%m-%d') as projectStart, 
       date_format(p.project_end, '%Y-%m-%d') as projectSEnd, 
       p.project_state as projectState, 
	   date_format(p.project_regdate, '%Y-%m-%d') as projectRegDate,
       up.ownership as ownerShip,
	   o.ownerName as ownerName
from userproject as up join user as u on up.user_no = u.user_no
join project as p on up.project_no = p.project_no
join (select up.project_no as project_no, u.user_name as ownerName from userproject as up join user as u  
on up.user_no = u.user_no
where ownership='O') as o
on up.project_no = o.project_no
where up.user_no = 1;

select up.project_no, u.user_name from userproject as up join user as u  
on up.user_no = u.user_no
where ownership='O';

select * from userproject where project_no= 11;
select * from task;

-- 캘린더

select * from task join tasklist;

-- 개인업무
select * from schedule;
select schedule_no as scheduleNo, user_no as userNo, schedule_start as scheduleStart, schedule_end as scheduleEnd, schedule_contents as scheduleContents from schedule where user_no = 1;
insert into schedule values(null, 1, '2021-12-25', '2021-12-27', '면접 준비');
update schedule set schedule_contents = '숙제하기 수정테스트', schedule_start = now(), schedule_end = now()+30  where schedule_no = 19; 

select schedule_no as scheduleNo, user_no as userNo, schedule_start as scheduleStart, schedule_end as scheduleEnd, schedule_contents as scheduleContents from schedule where user_no = 1;
select * from task as t join schedule as s on t.user_no = s.user_no;
select * from task;

select schedule_no as scheduleNo, user_no as userNo, schedule_start as scheduleStart, schedule_end as scheduleEnd, schedule_contents as scheduleContents 
from schedule where schedule_no = 3;

select * from schedule;
update schedule set schedule_contents = '스케줄 수정 테스트1', schedule_start = '1999-01-01', schedule_end = '1999-01-02' where schedule_no = 3; 


delete from userproject where user_no=1 and project_no=11 and ownership='M';

delete from schedule where schedule_no = 24;

select schedule_no as scheduleNo, user_no as userNo, schedule_start as scheduleStart, schedule_end as scheduleEnd, schedule_contents as scheduleContents 
from schedule as s where schedule_no = 25;
            
select * from schedule as s join user u on s.user_no = u.user_no;

select * from task;
select t.task_contents as taskContents, date_format(t.task_start, '%Y-%m-%d') as taskStart, date_format(t.task_end, '%Y-%m-%d') as taskEnd, task_label as taskLabel, task_order as taskOrder from 
taskuser as tu join task as t on tu.task_no = t.task_no where tu.user_no = 1 and task_state = 'do';

update taskuser set user_no = '2' where task_no = 9;

-- 개인 일정
select * from schedule;
delete from schedule where schedule_no=24;

select * from task;

update task set task_regdate='2021-12-05 14:30:00' where tasklist_no =1;

select user_no as userNo, user_email as userEmail, user_name as userName, user_photo as userPhoto from user where user_name like '%%' and user_state='T';














