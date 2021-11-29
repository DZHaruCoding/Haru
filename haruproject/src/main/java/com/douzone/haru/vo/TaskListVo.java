package com.douzone.haru.vo;

public class TaskListVo {
	private long projectNo;
	private long taskListNo;
	private String taskListName;
	private long taskListOrder;
	private String taskListState;
	
	public long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(long projectNo) {
		this.projectNo = projectNo;
	}
	public long getTaskListNo() {
		return taskListNo;
	}
	public void setTaskListNo(long taskListNo) {
		this.taskListNo = taskListNo;
	}
	public String getTaskListName() {
		return taskListName;
	}
	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}
	public long getTaskListOrder() {
		return taskListOrder;
	}
	public void setTaskListOrder(long taskListOrder) {
		this.taskListOrder = taskListOrder;
	}
	public String getTaskListState() {
		return taskListState;
	}
	public void setTaskListState(String taskListState) {
		this.taskListState = taskListState;
	}
	@Override
	public String toString() {
		return "TaskListVo [projectNo=" + projectNo + ", taskListNo=" + taskListNo + ", taskListName=" + taskListName
				+ ", taskListOrder=" + taskListOrder + ", taskListState=" + taskListState + "]";
	}
	
	
	
}
