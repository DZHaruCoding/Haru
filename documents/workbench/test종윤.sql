select * from user;

select * from userproject;
select * from file;
select * from history;
select * from noticeset;
select * from noticemessage;
select * from noticemsgbox;
select * from schedule;
select * from taglist;
select * from tagtask;
select * from task;
select * from tasklist;
select * from taskuser;
select * from project;
select * from comment;
select * from checklist;

-- checklist

-- insertChecklist
-- insert
--   into checklist (checklist_contents,task_no)
-- values (#{checklistContents}, #{taskNo});

insert
  into checklist (checklist_contents,task_no)
values ('checklist_contents', 1);

-- checklistDelete
-- DELETE
--   FROM checklist
--  WHERE checklist_no = #{checklistNo};

DELETE FROM checklist WHERE checklist_no = 28;

-- selectHistory
-- select log_no as logNo,	log_date as logDate, log_contents as logContents, project_no as ProjectNo
--   from history
--  where project_no = #{projectNo}
--  order by log_no desc;
select log_no as logNo,	log_date as logDate, log_contents as logContents, project_no as ProjectNo
  from history
 where project_no = 1
 order by log_no desc;
 
-- insertHistory
-- insert into history (project_no, log_contents)
-- values( #{projectNo},#{logContents});
insert into history (project_no, log_contents)
values( 1, 'log_contents');

-- findByFileNo
-- select change_name 
--   from file
--  where file_no = #{fileNo}
select change_name 
  from file
 where file_no = 1;

-- insertFile
-- insert
--   into file (task_no, file_no, origin_name, change_name, file_path, file_regdate, file_state, file_maker)
-- values (#{taskNo}, #{originName}, #{changeName}, #{filePath}, #{fileMaker})
insert
  into file (task_no, origin_name, change_name, file_path, file_maker)
values (1, '12', '23','34','file_maker');

-- selectFile
-- select distinct
-- 		p.project_no as projectNo,
--      p.project_title as projectTitle,
--      tl.tasklist_no as tasklistNo,
--      tl.tasklist_name as tasklistName,
-- 		t.task_no as taskNo,
-- 		t.task_contents as taskContents,
-- 		t.task_state as taskState,
-- 		f.file_no as fileNo,
--      f.file_path as filePath, 
--      f.origin_name as originName,
--      f.file_regdate as fileRegdate,
--      f.file_state as fileState,
--      f.file_maker as fileUploader
-- from project p
-- join tasklist tl on (p.project_no = tl.project_no)
-- join task t on (tl.tasklist_no = t.tasklist_no)
-- join file f on(t.task_no = f.task_no)
-- where p.project_no=#{projectNo} and t.task_state!='del' and f.file_state = 'T';

select distinct
		p.project_no as projectNo,
        p.project_title as projectTitle,
        tl.tasklist_no as tasklistNo,
        tl.tasklist_name as tasklistName,
		t.task_no as taskNo,
		t.task_contents as taskContents,
		t.task_state as taskState,
		f.file_no as fileNo,
        f.file_path as filePath, 
        f.origin_name as originName,
        f.file_regdate as fileRegdate,
        f.file_state as fileState,
        f.file_maker as fileUploader
from project p
join tasklist tl on (p.project_no = tl.project_no)
join task t on (tl.tasklist_no = t.tasklist_no)
join file f on(t.task_no = f.task_no)
where p.project_no=1 and t.task_state!='del' and f.file_state = 'T';
