/*
 * The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
 * The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
 * Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
 * The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
 */
package mobileApp;

import java.util.Date;

public class Appointment {
	
	private String appointmentId, appointmentDescription;
	Date appointmentDate;
	
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		
		createAppointmentId(appointmentId);
		updateAppointmentDate(appointmentDate);
		updateAppointmentDescription(appointmentDescription);	
	}

	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	protected void createAppointmentId(String appointmentId) {
			if(appointmentId == null) {
				
				throw new IllegalArgumentException("Appointment ID is null");
				
			} else if (appointmentId.length() > 10) {
				
				throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters.");
				
			} else {
				
				this.appointmentId = appointmentId;
				
			}
		}

	protected void updateAppointmentDate(Date appointmentDate) {
		Date currentDate = new Date();
		
		if (appointmentDate == null) {
			
			throw new IllegalArgumentException("Appointment date is null");
			
		} else if (appointmentDate.before(currentDate)) {
			
			throw new IllegalArgumentException("Appointment date is in the past");
			
		} else {
			
			this.appointmentDate = appointmentDate;
			
		}
	}

	protected void updateAppointmentDescription(String appointmentDescription) {
		if(appointmentDescription == null) {
			
			throw new IllegalArgumentException("Appointment description is null");
			
		} else if (appointmentDescription.length() > 50) {
			
			throw new IllegalArgumentException("Appointment description is greater than 50 characters");
		} else {
			
			this.appointmentDescription = appointmentDescription;
		}
	}
}
