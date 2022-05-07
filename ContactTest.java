package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {
	
	private String contactId, firstName, lastName, phone, address;
	private String firstNameUpdate, lastNameUpdate, phoneUpdate, addressUpdate;
	private String longFirstName, longLastName, longPhone, longAddress;
	private String shortPhone;
	Contact contact;

	@BeforeEach
	void setUp() throws Exception {
		
		contactId = "0123456789";
		firstName = "Sergio";
		lastName = "Udave";
		phone = "0123456789";
		address = "123 Sesame Street";
		
		firstNameUpdate = "Victoria";
		lastNameUpdate = "Hamilton";
		phoneUpdate = "1111111111";
		addressUpdate = "Abigail Adams St.";
		
		longFirstName = "John Quincy Junior";
		longLastName = "Abigail Adams";
		longPhone = "012345678911";
		longAddress = "1234567890 Abigail Adams John Quincy Adams Street";
		
		shortPhone = "123";
		
		contact = new Contact(contactId, firstName, lastName, phone, address);
		
	}
	
	@DisplayName("Contact is filled out properly")
	@Test
	void filledContactConstructor() {
		assertAll("Filled Out Contact",
				
				()
					-> assertEquals(contactId, contact.getContactId()),
					
				()
					-> assertEquals(firstName, contact.getFirstName()),
					
				()
					-> assertEquals(lastName, contact.getLastName()),
					
				()
					-> assertEquals(phone, contact.getPhone()),
					
				()
					-> assertEquals(address, contact.getAddress()));
		
	}
	
	@DisplayName("First name shall be updatable")
	@Test
	void updateFirstNameTest() {
	    contact.updateFirstName(firstNameUpdate);
	    
	    assertEquals(firstNameUpdate, contact.getFirstName());
	  }
	
	@DisplayName("First name cannot be greater than 10 characters")
	@Test
	void updateFirstnameIsTooLongTest() {
		assertThrows(IllegalArgumentException.class,
				()
					-> contact.updateFirstName(longFirstName));
	}
	
	@DisplayName("Last name shall be updatable")
	@Test
	void updateLastNameTest() {
		contact.updateLastName(lastNameUpdate);
		
		assertEquals(lastNameUpdate, contact.getLastName());
	}
	
	@DisplayName("Last name cannot be longer than 10 characters")
	@Test
	void updateLastNameIsTooLongTest() {
		assertThrows(IllegalArgumentException.class,
				()
					-> contact.updateLastName(longLastName));
	}
	
	@DisplayName("Phone shall be updatable")
	@Test
	void updatePhoneNumberTest() {
		contact.updatePhoneNumber(phoneUpdate);
		
		assertEquals(phoneUpdate, contact.getPhone());
	}
	
	@DisplayName("Phone number must be exactly 10 digits")
	@Test
	void updatePhoneNumberIsTooLongTest() {
		assertAll(
				()
					-> assertThrows(IllegalArgumentException.class,
							()
								-> contact.updatePhoneNumber(longPhone)),
				()
					-> assertThrows(IllegalArgumentException.class,
							()
								-> contact.updatePhoneNumber(shortPhone)));
					
	}
	
	@DisplayName("Address shall be updatable")
	@Test
	void updateAddressTest() {
		contact.updateAddress(addressUpdate);
		
		assertEquals(addressUpdate, contact.getAddress());
	}
	
	@DisplayName("Address cannot be longer than 30 characters")
	@Test
	void updateAddressIsTooLongTest() {
		assertThrows(IllegalArgumentException.class,
				()
					-> contact.updateAddress(longAddress));
		
	}

}
