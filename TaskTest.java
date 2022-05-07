package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

class TaskTest {
	
	private String taskIdTest, nameTest, descriptionTest;
	private String tooLongTaskId, tooLongName, tooLongDescription;
	Task task;
	
	@BeforeEach
	void setup() {
		taskIdTest = "0123456789";
		nameTest = "Valid string";
		descriptionTest = "This is a valid description";
		
		tooLongTaskId = "0123456789011";
		tooLongName = "This name is too long";
		tooLongDescription = "This description is too long. This description is too long. This description is too long."
				+ "This description is too long. This description is too long.";
		
		task = new Task(taskIdTest, nameTest, descriptionTest);
	}

	@DisplayName("Valid task created")
	@Test
	void testTask() {	
		assertAll("Filled out task",
				()
					-> assertEquals(taskIdTest, task.getTaskId()),
				()
					-> assertEquals(nameTest, task.getName()),
				()
					-> assertEquals(descriptionTest, task.getDescription()));
	}
	
	@DisplayName("Task ID cannot be null")
	@Test
	void testUniqueId() {
		assertNotNull(taskIdTest, task.getTaskId());	
	}
	
	@DisplayName("Task ID cannot be longer than 10 characters")
	@Test
	void testUniqueIdLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			task = new Task(tooLongTaskId, nameTest, descriptionTest);
		});
	}
	
	@DisplayName("Name cannot be longer than 20 characters")
	@Test
	void testNameLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			task = new Task(taskIdTest, tooLongName, descriptionTest);
		});
	}
	
	@DisplayName("Name cannot be null")
	@Test
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task = new Task(taskIdTest, null, descriptionTest);
		});	
	}
	
	@DisplayName("Description cannot be longer than 50 characters")
	@Test
	void testDescriptionLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			task = new Task(taskIdTest, nameTest, tooLongDescription);
		});
	}
	
	@DisplayName("Description cannot be null")
	@Test
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task = new Task(taskIdTest, nameTest, null);
		});
	}

}
