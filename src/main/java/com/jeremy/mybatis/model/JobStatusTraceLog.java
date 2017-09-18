/**
 * 
 */
package com.jeremy.mybatis.model;

import java.sql.Timestamp;

/**
 * @author jeremy
 *
 */
public class JobStatusTraceLog {
	private String id;
	private String job_name;
	private String original_task_id;
	private String task_id;
	private String slave_id;
	private String source;
	private String execution_type;
	private String sharding_item;
	private String state;
	private String message;
	private Timestamp creation_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getOriginal_task_id() {
		return original_task_id;
	}

	public void setOriginal_task_id(String original_task_id) {
		this.original_task_id = original_task_id;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getSlave_id() {
		return slave_id;
	}

	public void setSlave_id(String slave_id) {
		this.slave_id = slave_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getExecution_type() {
		return execution_type;
	}

	public void setExecution_type(String execution_type) {
		this.execution_type = execution_type;
	}

	public String getSharding_item() {
		return sharding_item;
	}

	public void setSharding_item(String sharding_item) {
		this.sharding_item = sharding_item;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Timestamp creation_time) {
		this.creation_time = creation_time;
	}

	@Override
	public String toString() {
		return "TaskStatusTraceLog [id=" + id + ", job_name=" + job_name + ", original_task_id=" + original_task_id
				+ ", task_id=" + task_id + ", slave_id=" + slave_id + ", source=" + source + ", execution_type="
				+ execution_type + ", sharding_item=" + sharding_item + ", state=" + state + ", message=" + message
				+ ", creation_time=" + creation_time + "]";
	}

	
}
