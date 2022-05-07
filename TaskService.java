/*
 * Author: Sergio Udave
 * 
 * TaskService.java requirements:
 * The task service shall be able to add tasks with a unique ID.
 * The task service shall be able to delete tasks per task ID.
 * The task service shall be able to update task fields per task ID. 
 * The following fields are updatable: name, description
 */
package mobileApp;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;

public class TaskService {
	
	private String taskId;
	private List<Task> taskList = new ArrayList<>();
	
	public void newTask(String taskId, String name, String description) {
		Task task = new Task(newUniqueId(), name, description);
		taskList.add(task);
	}
	
	private Task searchForTask(String taskId) throws Exception {
		int index = 0;
		
		while (index < taskList.size()) {
			
			if (taskId.equals(taskList.get(index).getTaskId())) {
				
				return taskList.get(index);	
			}
			
			index++;
		}
		
		throw new Exception("The task does not exist.");	
	}
	
	private String newUniqueId() {
		String uniqueId = generateRandomString(10);
		return uniqueId;
	}
	
	public static String generateRandomString(int length) {
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		String NUMBER = "0123456789";
		
		String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
		SecureRandom random = new SecureRandom();
		
		if (length < 1) throw new IllegalArgumentException();
		
		StringBuilder sb = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
			
			sb.append(rndChar);
		}
		
		return sb.toString();
	}

	public void updateName(String id, String name) throws Exception {	
		searchForTask(id).updateName(name);
	}
	
	public void updateDescription(String id, String description) throws Exception {
		searchForTask(id).updateDescription(description);
	}
	
	protected List<Task> getTaskList() {
		return taskList;
	}
	
	public void deleteTask(String id) throws Exception {
		taskList.remove(searchForTask(id));
	}
	
}
