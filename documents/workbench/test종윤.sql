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
