-- 종윤

-- checklist
SELECT task_no, checklist_no, checklist_contents, checklist_state
  FROM checklist;

INSERT 
  INTO checklist (task_no, checklist_no, checklist_contents)
VALUES (task_no, checklist_no, checklist_contents);

UPDATE checklist	
   SET task_no = task_no,
	   checklist_no = checklist_no,
	   checklist_contents = checklist_contents,
	   checklist_state = do
 WHERE checklist_no = checklist_no;
 
INSERT INTO `haru`.`comment`
(`user_no`,
`task_no`,
`comment_no`,
`comment_regdate`,
`comment_contents`,
`comment_state`)
VALUES
(<{user_no: }>,
<{task_no: }>,
<{comment_no: }>,
<{comment_regdate: CURRENT_TIMESTAMP}>,
<{comment_contents: }>,
<{comment_state: T}>);

INSERT INTO `haru`.`file`
(`task_no`,
`file_no`,
`origin_name`,
`change_name`,
`file_path`,
`file_regdate`,
`file_state`,
`file_maker`)
VALUES
(<{task_no: }>,
<{file_no: }>,
<{origin_name: }>,
<{change_name: }>,
<{file_path: }>,
<{file_regdate: CURRENT_TIMESTAMP}>,
<{file_state: T}>,
<{file_maker: }>);


INSERT INTO `haru`.`history`
(`project_no`,
`log_no`,
`log_date`,
`log_contents`)
VALUES
(<{project_no: }>,
<{log_no: }>,
<{log_date: CURRENT_TIMESTAMP}>,
<{log_contents: }>);


INSERT INTO `haru`.`noticemessage`
(`notice_no`,
`notice_message`,
`notice_link`,
`notice_date`)
VALUES
(<{notice_no: }>,
<{notice_message: }>,
<{notice_link: }>,
<{notice_date: CURRENT_TIMESTAMP}>);


INSERT INTO `haru`.`noticemsgbox`
(`notice_no`,
`user_no`,
`message_ck`)
VALUES
(<{notice_no: }>,
<{user_no: }>,
<{message_ck: N}>);


INSERT INTO `haru`.`noticeset`
(`user_no`,
`noticeset_assigh`,
`noticeset_comment`)
VALUES
(<{user_no: }>,
<{noticeset_assigh: }>,
<{noticeset_comment: }>);


INSERT INTO `haru`.`project`
(`project_no`,
`project_title`,
`project_desc`,
`project_start`,
`project_end`,
`project_state`,
`project_regdate`)
VALUES
(<{project_no: }>,
<{project_title: }>,
<{project_desc: }>,
<{project_start: CURRENT_TIMESTAMP}>,
<{project_end: }>,
<{project_state: T}>,
<{project_regdate: }>);


INSERT INTO `haru`.`schedule`
(`schedule_no`,
`user_no`,
`schedule_start`,
`schedule_end`,
`schedule_contents`)
VALUES
(<{schedule_no: }>,
<{user_no: }>,
<{schedule_start: }>,
<{schedule_end: }>,
<{schedule_contents: }>);
INSERT INTO `haru`.`taglist`
(`tag_no`,
`tag_name`,
`tag_color`)
VALUES
(<{tag_no: }>,
<{tag_name: }>,
<{tag_color: }>);
INSERT INTO `haru`.`tagtask`
(`taglist_tag_no`,
`task_task_no`)
VALUES
(<{taglist_tag_no: }>,
<{task_task_no: }>);
INSERT INTO `haru`.`task`
(`tasklist_no`,
`task_no`,
`task_start`,
`task_end`,
`task_label`,
`task_state`,
`task_contents`,
`task_order`,
`task_regdate`,
`task_writer`)
VALUES
(<{tasklist_no: }>,
<{task_no: }>,
<{task_start: CURRENT_TIMESTAMP}>,
<{task_end: }>,
<{task_label: }>,
<{task_state: do}>,
<{task_contents: }>,
<{task_order: }>,
<{task_regdate: }>,
<{task_writer: }>);
INSERT INTO `haru`.`tasklist`
(`project_no`,
`tasklist_no`,
`tasklist_name`,
`tasklist_order`,
`tasklist_state`)
VALUES
(<{project_no: }>,
<{tasklist_no: }>,
<{tasklist_name: }>,
<{tasklist_order: }>,
<{tasklist_state: T}>);
INSERT INTO `haru`.`taskuser`
(`user_no`,
`task_no`)
VALUES
(<{user_no: }>,
<{task_no: }>);
INSERT INTO `haru`.`user`
(`user_no`,
`user_regdate`,
`user_email`,
`user_name`,
`user_password`,
`user_number`,
`user_birth`,
`user_title`,
`user_dept`,
`user_photo`,
`user_bg`,
`user_key`,
`user_state`)
VALUES
(<{user_no: }>,
<{user_regdate: CURRENT_TIMESTAMP}>,
<{user_email: }>,
<{user_name: }>,
<{user_password: }>,
<{user_number: }>,
<{user_birth: }>,
<{user_title: }>,
<{user_dept: }>,
<{user_photo: }>,
<{user_bg: }>,
<{user_key: }>,
<{user_state: T}>);
INSERT INTO `haru`.`userproject`
(`user_no`,
`project_no`,
`ownership`)
VALUES
(<{user_no: }>,
<{project_no: }>,
<{ownership: O}>);

