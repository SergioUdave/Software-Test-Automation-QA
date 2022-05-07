/*
 * Author: Sergio Udave
 * 
 * ContactService.java requirements:
 * 1. The contact service shall be able to add contacts with a unique ID.
 * 2. The contact service shall be able to delete contacts per contact ID.
 * 3. The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
 * 	  First Name
 * 	  Last Name
 * 	  Number
 * 	  Address
 */

package mobileApp;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;

public class ContactService {
	
	private String contactId;
	
	private List<Contact> contactList = new ArrayList<>();
	
	// Create contact with all required fields
	public void newContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phone, address);
		contactList.add(contact);
	}
	

	private Contact searchForContact(String contactId) throws Exception {	
		int index = 0;
			
		while (index < contactList.size()) {
				
			if (contactId.equals(contactList.get(index).getContactId())) {
					
				return contactList.get(index);
					
			}
				
			index++;
		}
			
		throw new Exception("The contact does not exist");
			
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
		
		if ( length < 1) throw new IllegalArgumentException();
		
		StringBuilder sb = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
			
			sb.append(rndChar);
			
		}
		
		return sb.toString();
	}
	
	public void updateFirstName(String id, String firstName) throws Exception {
		searchForContact(id).updateFirstName(firstName);
	  }

	public void updateLastName(String id, String lastName) throws Exception {
	    searchForContact(id).updateLastName(lastName);
	  }

	public void updatePhoneNumber(String id, String phone)
	      throws Exception {
	    searchForContact(id).updatePhoneNumber(phone);
	  }

	public void updateAddress(String id, String address) throws Exception {
	    searchForContact(id).updateAddress(address);
	  }
	  
	protected List<Contact> getContactList() {
		  return contactList;
	  }
	
	public void deleteContact(String id) throws Exception {
		contactList.remove(searchForContact(id));	
	}

	  
}

	