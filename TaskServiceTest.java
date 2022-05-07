package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class TaskServiceTest {
	
	private String taskIdTest, nameTest, descriptionTest;
	private String nameUpdate, descriptionUpdate;
	TaskService service;
	
	@BeforeEach
	void setup() {
		service = new TaskService();
		
		taskIdTest = "0123456789";
		nameTest = "Valid string";
		descriptionTest = "This is a valid description";
		
		nameUpdate = "String valid";
		descriptionUpdate = "Another valid description";
	}

	
	@DisplayName("Create task with unique ID")
	@Test
	void testAddTask() {
		service.newTask(taskIdTest, nameTest, descriptionTest);
		assertAll("Filled out task",
				()
					-> assertNotNull(service.getTaskList().get(0).getTaskId()),
				()
					-> assertEquals("Valid string", service.getTaskList().get(0).getName()),
				()
					-> assertEquals("This is a valid description", service.getTaskList().get(0).getDescription()));
	}
	
	@DisplayName("Delete task per ID")
	@Test
	void testDeleteTask() {
		service.newTask(taskIdTest, nameTest, descriptionTest);
		assertAll(() -> service.deleteTask(service.getTaskList().get(0).getTaskId()));
	}
	
	@DisplayName("Name field is updatable")
	@Test
	void testUpdateName() throws Exception {
		service.newTask(taskIdTest, nameTest, descriptionTest);
		service.updateName(service.getTaskList().get(0).getTaskId(), nameUpdate);
		assertEquals(nameUpdate, service.getTaskList().get(0).getName());
	}
	
	@DisplayName("Description field is updatable")
	@Test
	void testUpdateDescription() throws Exception {
		service.newTask(taskIdTest, nameTest, descriptionTest);
		service.updateDescription(service.getTaskList().get(0).getTaskId(), descriptionUpdate);
		assertEquals(descriptionUpdate, service.getTaskList().get(0).getDescription());
	}
	
	
	
	

}
