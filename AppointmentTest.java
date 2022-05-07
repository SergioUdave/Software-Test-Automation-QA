package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class AppointmentTest {
	
	private String appointmentIdTest, appointmentDescriptionTest;
	private String tooLongId, tooLongDescription;
	Date appointmentDate, badAppointmentDate;
	Appointment appointment;
	
	@BeforeEach
	void setup() {
		
		appointmentIdTest = "0123456789";
		appointmentDescriptionTest = "This is a valid description";
		tooLongDescription = "This is a description that is more than fifty characters long";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			appointmentDate = dateFormat.parse("25/04/2022");
			badAppointmentDate = dateFormat.parse("25/03/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		appointment = new Appointment(appointmentIdTest, appointmentDate, appointmentDescriptionTest);
	}
	
	@DisplayName("Valid appointment created")
	@Test
	void testAppointment() {
		assertAll("Filled out appointment",
				()
					-> assertEquals(appointmentIdTest, appointment.getAppointmentId()),
				()
					-> assertEquals(appointmentDescriptionTest, appointment.getAppointmentDescription()),
				()
					-> assertEquals(appointmentDate, appointment.getAppointmentDate()));
	}
	
	@DisplayName("Appointment ID cannot be null")
	@Test
	void testUniqueIdNull() {
		assertNotNull(appointmentIdTest, appointment.getAppointmentId());
	}
	
	@DisplayName("Appointment ID cannot be longer than 10 characters")
	@Test
	void testUniqueIdLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(tooLongId, appointmentDate, appointmentDescriptionTest);
		});
	}
	
	@DisplayName("Date cannot be in the past")
	@Test
	void testAppointmentDateInPast() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(appointmentIdTest, badAppointmentDate, appointmentDescriptionTest);
		});	
	}
	
	@DisplayName("Date cannot be null")
	@Test
	void testAppointmentDateNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(appointmentIdTest, null, appointmentDescriptionTest);
		});
	}
	
	@DisplayName("Description cannot be longer than 50 characters")
	@Test
	void testDescriptionLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(appointmentIdTest, appointmentDate, tooLongDescription);
		});
	}
	
	@DisplayName("Description cannot be null")
	@Test
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(appointmentIdTest, appointmentDate, null);
		});
	}
	
	

}
