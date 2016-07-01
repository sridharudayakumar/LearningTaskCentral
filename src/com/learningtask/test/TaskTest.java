package com.learningtask.test;

import com.learningtask.context.AppConfig;

import com.learningtask.dao.TaskDao;
import com.learningtask.dto.Task;

public class TaskTest {
	public static void main(String[] args) {
		
		Task task = new Task();
		task.setUserTaskSid(5);
		task.setUserId(1);
		task.setCourseId(101);
		
		AppConfig appConfig = new AppConfig();
		TaskDao taskDao = new TaskDao(appConfig);
		taskDao.addTask(task);
		System.out.println("Inserted");
		
	}

}
