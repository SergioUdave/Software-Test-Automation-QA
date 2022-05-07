package mobileApp;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.util.Date;

public class AppointmentService {
	
	private String appointmentId;
	
	private List<Appointment> appointmentList = new ArrayList<>();
	
	public void newAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		Appointment appointment = new Appointment(newUniqueId(), appointmentDate, appointmentDescription);
		appointmentList.add(appointment);
		
	}
	
	private Appointment searchForAppointment(String appointmentId) throws Exception {
			int index = 0;
			
			while (index < appointmentList.size()) {
				
				if (appointmentId.equals(appointmentList.get(index).getAppointmentId())) {
					
					return appointmentList.get(index);	
				}
				
				index++;
			}
			
			throw new Exception("The appointment does not exist.");	
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
	
	public void updateAppointmentDate(String id, Date appointmentDate) throws Exception {
		searchForAppointment(id).updateAppointmentDate(appointmentDate);
	}
	
	public void updateAppointmentDescription(String id, String appointmentDescription) throws Exception {	
		searchForAppointment(id).updateAppointmentDescription(appointmentDescription);
	}

	protected List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	public void deleteAppointment(String id) throws Exception {
		appointmentList.remove(searchForAppointment(id));
	}
}