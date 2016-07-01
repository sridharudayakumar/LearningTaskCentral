package com.learningtask.dao;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learningtask.context.AppConfig;
import com.learningtask.dto.Task;


@Repository
public class TaskDao {
	
	//private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private JdbcOperations jdbcOperations;
	private NamedParameterJdbcTemplate namedParameter;
	
	
	public TaskDao(AppConfig ds)
	{
		//this.dataSource = ds.getDataSource();
		this.jdbcTemplate= new JdbcTemplate(ds.getDataSource());
		this.namedParameter = new NamedParameterJdbcTemplate(ds.getDataSource());
		
	}
	
	private static final String INSERT_TASK = "insert into task (TASK_ID,USER_ID,COURSE_ID)values (:userTaskSid,:userId,:courseId)";
	//private static final String INSERT_TASK = "insert into task(userTaskSid, ,userId,courseId) values (?,?,?)";
	public  void addTask(Task task)
	{
		
		/*//JdbcTemplate
		String query="insert into task values('"+task.getUserTaskSid()+"','"+task.getUserId()+"','"+task.getCourseId()+"')";  
		jdbcTemplate.update(query); */
		
		//JdbcTemplate with PreparedStatement
		/*String sql = "INSERT INTO TASK (TASK_ID,USER_ID,COURSE_ID) values (?,?,?)";
		Object[] objects = new Object[] { task.getUserTaskSid(), task.getUserId(),task.getCourseId() };
		jdbcTemplate.update(sql, objects);
		 */		
		
		//NamedParameter
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userTaskSid", task.getUserTaskSid());
		paramMap.put("userId", task.getUserId());
		paramMap.put("courseId", task.getCourseId());
		namedParameter.update(INSERT_TASK, paramMap);
	
	
	}
	

}
