/*
 * Author: Sergio Udave
 * 
 * Task.java requirements:
 * The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
 * The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
 * The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
 */
package mobileApp;

public class Task {
	
	private String taskId, name, description;
	
	public Task(String taskId, String name, String description) {
		createTaskId(taskId);
		updateName(name);
		updateDescription(description);
	}
	
	public String getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	protected void createTaskId(String taskId) {	
		if(taskId == null) {
			
			throw new IllegalArgumentException("Task ID is null");
			
		} else if (taskId.length() > 10) {
			
			throw new IllegalArgumentException("Task ID cannot be longer than 10 characters.");
			
		} else {
			this.taskId = taskId;
		}
	}
	
	protected void updateName(String name) {
		if(name == null) {
			
			throw new IllegalArgumentException("Name is null");
			
		} else if (name.length() > 20) {
			
			throw new IllegalArgumentException("Name cannot be longer than 20 characters");
			
		} else {
			
			this.name = name;
		}
	}
	
	protected void updateDescription(String description) {
		if(description == null) {
			
			throw new IllegalArgumentException("Description is null");
			
		} else if (description.length() > 50) {
			
			throw new IllegalArgumentException("Description cannot be longer than 50 characters");
			
		} else {
			this.description = description;
		}
	}
}
