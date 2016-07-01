package com.learningtask.dto;

public class Task {

	private int userTaskSid;
	private int userId;
	private int courseId;
	private String task;
	public int getUserTaskSid() {
		return userTaskSid;
	}
	public void setUserTaskSid(int userTaskSid) {
		this.userTaskSid = userTaskSid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
}
