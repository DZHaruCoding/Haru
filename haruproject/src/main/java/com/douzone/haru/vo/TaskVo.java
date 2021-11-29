package com.douzone.haru.vo;

public class TaskVo {

	private long taskListNo;
	private long taskNo;
	private String taskStart;
	private String taskEnd;
	private String taskLabel;
	private String taskState;
	private String taskContents;
	private long taskOrder;
	private String taskRegdate;
	private String taskWriter;
	
	public long getTaskListNo() {
		return taskListNo;
	}
	public void setTaskListNo(long taskListNo) {
		this.taskListNo = taskListNo;
	}
	public long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(long taskNo) {
		this.taskNo = taskNo;
	}
	public String getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}
	public String getTaskEnd() {
		return taskEnd;
	}
	public void setTaskEnd(String taskEnd) {
		this.taskEnd = taskEnd;
	}
	public String getTaskLabel() {
		return taskLabel;
	}
	public void setTaskLabel(String taskLabel) {
		this.taskLabel = taskLabel;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public String getTaskContents() {
		return taskContents;
	}
	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}
	public long getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(long taskOrder) {
		this.taskOrder = taskOrder;
	}
	public String getTaskRegdate() {
		return taskRegdate;
	}
	public void setTaskRegdate(String taskRegdate) {
		this.taskRegdate = taskRegdate;
	}
	public String getTaskWriter() {
		return taskWriter;
	}
	public void setTaskWriter(String taskWriter) {
		this.taskWriter = taskWriter;
	}
	@Override
	public String toString() {
		return "TaskVo [taskListNo=" + taskListNo + ", taskNo=" + taskNo + ", taskStart=" + taskStart + ", taskEnd="
				+ taskEnd + ", taskLabel=" + taskLabel + ", taskState=" + taskState + ", taskContents=" + taskContents
				+ ", taskOrder=" + taskOrder + ", taskRegdate=" + taskRegdate + ", taskWriter=" + taskWriter + "]";
	}
	
	
	
	
}
