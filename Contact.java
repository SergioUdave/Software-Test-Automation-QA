/*
 * Author: Sergio Udave
 * 
 * Contact.java requirements:
 * 1. The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
 * 2. The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null. 
 * 3. The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
 * 4. The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
 * 5. The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
 */
package mobileApp;

public class Contact {
	
	private String contactId, firstName, lastName, phone, address;
		
	/*
	 * Contact object is created with all fields being required. All fields are checked if they 
	 * are null by the methods within the Contact object, and the methods check for the character
	 * limit as dictated for each parameter.
	 */
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {	
		createContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phone);
		updateAddress(address);	
	}
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	protected void createContactId(String contactId) {
		if (contactId == null) {
			
			throw new IllegalArgumentException("contactId is null");
			
		} else if (contactId.length() > 10) {
			
			throw new IllegalArgumentException("contactId cannot be greater than 10 digits");
			
		} else {
			
			this.contactId = contactId;
			
		}
	}
	
	protected void updateFirstName(String firstName) {
			if (firstName == null) {
				
				throw new IllegalArgumentException("First name is null.");
				
			} else if (firstName.length() > 10) {
				
				throw new IllegalArgumentException("First name cannot be longer than 10 characters");
				
			} else {
				
				this.firstName = firstName;
			}
			
		}
		
	protected void updateLastName(String lastName) {	
			if (lastName == null) {
				
				throw new IllegalArgumentException("Last name is null");
				
			} else if (lastName.length() > 10) {
				
				throw new IllegalArgumentException("Last name is longer than 10 characters.");
				
			} else {
				
				this.lastName = lastName;
			}
			
		}
		
	protected void updatePhoneNumber(String phone) {	
			if (phone == null) {
				
				throw new IllegalArgumentException("Field cannot be blank");
				
			} else if (phone.length() != 10) {
				
				throw new IllegalArgumentException("Phone number must be 10 characters long");
				
			} else {
				
				this.phone = phone;
				
			}
			
		}
		
	protected void updateAddress(String address) {
			if (address == null) {
				
				throw new IllegalArgumentException("Field cannot be blank");
				
			} else if (address.length() > 30) {
				
				throw new IllegalArgumentException("Address cannot be longer than 30 characters");
				
			} else {
				
				this.address = address;
				
			}
		}
}
