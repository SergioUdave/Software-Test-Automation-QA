package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentServiceTest {
	
	private String appointmentIdTest, appointmentDescriptionTest;
	AppointmentService service;
	Date appointmentDate;
	
	@BeforeEach
	void setup() {
		service = new AppointmentService();
		
		appointmentIdTest = "0123456789";
		appointmentDescriptionTest = "This is a valid description";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			appointmentDate = dateFormat.parse("25/04/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("Create appointment with unique ID")
	@Test
	void testAddAppointment() {
		service.newAppointment(appointmentIdTest, appointmentDate, appointmentDescriptionTest);
		assertAll("Filled out appointment",
				()
					-> assertNotNull(service.getAppointmentList().get(0).getAppointmentId()),
				()
					-> assertEquals("Mon Apr 25 00:00:00 CDT 2022", service.getAppointmentList().get(0).getAppointmentDate().toString()),
				()
					-> assertEquals("This is a valid description", service.getAppointmentList().get(0).getAppointmentDescription()));
	}
	
	@DisplayName("Delete appointment per ID")
	@Test
	void testDeleteAppointment() {
		service.newAppointment(appointmentIdTest, appointmentDate, appointmentDescriptionTest);
		assertAll(() -> service.deleteAppointment(service.getAppointmentList().get(0).getAppointmentId()));
	}

}
