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
-- insert into history values(#{projectNo}, null, now(), #{logContents})
