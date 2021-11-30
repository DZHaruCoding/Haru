select * from user;
select * from checklist;
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

-- taskSetting
-- insertChecklist
-- insert into checklist values(null, #{checklistContents}, #{checklistState}, #{taskNo})
insert
  into checklist (checklist_contents, checklist_state)
values (#{checklistContents}, #{checklistState}, #{taskNo});



