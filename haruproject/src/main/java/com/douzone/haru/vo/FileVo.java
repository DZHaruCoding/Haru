package com.douzone.haru.vo;

//파일 생성
public class FileVo {
	private Long taskNo; //업무 no (taskTable no)
	private Long fileNo; //파일 no
	private String originName; // 원본 파일 이름
	private String changeName; // 변경된 파일 이름
	private String filePath; // 파일 경로
	private String fileRegdate; //파일 생성일
	private String fileState; //파일 상태
	private String fileMaker; // 파일 생성 유저
	
	@Override
	public String toString() {
		return "FileVo [taskNo=" + taskNo + ", fileNo=" + fileNo + ", originName=" + originName + ", chandeName="
				+ changeName + ", filePath=" + filePath + ", fileRegdate=" + fileRegdate + ", fileState=" + fileState
				+ ", fileMaker=" + fileMaker + "]";
	}
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}
	public Long getFileNo() {
		return fileNo;
	}
	public void setFileNo(Long fileNo) {
		this.fileNo = fileNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String chandeName) {
		this.changeName = chandeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileRegdate() {
		return fileRegdate;
	}
	public void setFileRegdate(String fileRegdate) {
		this.fileRegdate = fileRegdate;
	}
	public String getFileState() {
		return fileState;
	}
	public void setFileState(String fileState) {
		this.fileState = fileState;
	}
	public String getFileMaker() {
		return fileMaker;
	}
	public void setFileMaker(String fileMaker) {
		this.fileMaker = fileMaker;
	}
	
}
