# Software-Test-Automation-QA
SNHU CS320 course centered around demonstrating unit testing with JUnit 5 tests. 

# Scenario
You are a software engineer for Grand Strand Systems, a software engineering company that focuses on developing and testing back-end services. You’ve been given an assignment to develop a mobile application for a customer. The customer will provide you with the requirements. Your job is to code up the application and provide unit tests to verify that it meets the customer’s requirements. You will be delivering the contact, task, and appointment services. The purpose of these services is to add, update, and delete contact, task, and appointment objects within the application.

# Directions
**Submit ContactService, TaskService, and AppointmentService .java files**  
You have been asked to code up a mobile application for a client and provide unit tests to verify that it meets the customer's requirements. In order to do so, you must complete the following:
1. **Contact Service:** In the Module Three milestone, you developed the contact service. The contact service used in-memory data structures to support storing contacts (no database required). In addition, there was no UI for this assignment. You verified the contact service through JUnit tests. The contact service contained a contact object along with the contact service. The requirements were as follows:  
   * a. Contact Class:
      - The Contact object shall have a required unique contact ID String that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
      - The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
      - The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
      - The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
      - The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
   * b. Contact Service class:  
      - The contact service shall be able to add contacts with unique ID.
      - The contact service shall be able to delete contacts per contactId.
      - The contact service shall be able to update contact fields per contactId.
      - The following fields are updatable:
        1. firstName
        2. lastName
        3. phoneNumber
        4. address  
2. **Task Service:** In the Module Four milestone, you developed the task service. The task service used in-memory data structures to support storing tasks (no database required). In addition, there was no UI for this assignment. You verified the task service through JUnit tests. The task service contained a task object along with the task service. The requirements were as follows:  
    * a. Task Class:
      - The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
      - The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
      - The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
    * b. Task Service Class:  
      - The task service shall be able to add tasks with a unique ID.
      - The task service shall be able to delete tasks per taskId.
      - The task service shall be able to update task fields per taskId.
      - The following fields are updatable: 
        1. name
        2. description  
3. **Appointment Service:** In the Module Five milestone, you developed the appointment service. The appointment service used in-memory data structures to support storing appointments (no database required). In addition, there was no UI for this assignment. You verified the appointment service through JUnit tests. The appointment service contained an appointment object along with the appointment service. The requirements were as follows:  
    * a. Appointment Class:  
      - The appointment object shall have a required unique appointment ID String that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
      - The appointment object shall have a required appointment Date field. The appointmentDate field cannot be in the past. The appointmentDate field shall not be null. Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
      - The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
    * b. Appointment Service Class:  
      - The appointment service shall be able to add appointments with a unique appointmentId.
      - The appointment service shall be able to delete appointments per appointmentId.  
Specifically, the following rubric criteria must be addressed:  
  - Verify that the Contact, ContactService, Task, TaskService, Appointment, AppointmentService classes meet the requirements through JUnit tests.
  - Ensure the **test coverage** for the .java files is **80%** or higher.
