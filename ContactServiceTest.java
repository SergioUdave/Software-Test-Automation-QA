package mobileApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactServiceTest {
	
	private String contactId, firstName, lastName, phone, address;
	private String firstNameUpdate, lastNameUpdate, phoneUpdate, addressUpdate;
	private String longFirstName, longLastName, longPhone, longAddress;
	private String shortPhone;
	ContactService service;
	

	@BeforeEach
	void setUp() throws Exception {
		service = new ContactService();
		
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
	}
	 
	 @DisplayName("Create contact with unique ID and valid contact values")
	 @Test
	 void createContactTest() {
		 
		
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Check that contact is created successfully with expected test values
		 assertAll(
				 "Filled Out Contact",
				 ()
				 	-> assertNotNull(service.getContactList().get(0).getContactId()),
				 ()
				 	-> assertEquals("Sergio",
				 					service.getContactList().get(0).getFirstName()),
				 ()
				 	-> assertEquals("Udave",
				 					service.getContactList().get(0).getLastName()),
				 ()
				 	-> assertEquals("0123456789",
				 					service.getContactList().get(0).getPhone()),
				 ()
				 	-> assertEquals("123 Sesame Street",
				 					service.getContactList().get(0).getAddress()));
	
	 }
	 
	 @DisplayName("Delete contact per contact ID")
	 @Test
	 void deleteContactTest () {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 assertAll(()-> service.deleteContact(service.getContactList().get(0).getContactId()));	 
	 }
	 
	 @DisplayName("Can update first name")
	 @Test
	 void updateFirstNameTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Update first name with new value
		 service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameUpdate);
		 
		 // Check updated name is equal to test value
		 assertEquals(firstNameUpdate, service.getContactList().get(0).getFirstName());
	 }
	 
	 @DisplayName("Cannot update first name that is too long")
	 @Test
	 void updateFirstNameIsLongTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Attempt to update first name with name that is too long
		 assertThrows(IllegalArgumentException.class,
				 ()
				 	-> service.updateFirstName(service.getContactList().get(0).getContactId(), longFirstName));
	 }
	 
	 @DisplayName("Can update last name")
	 @Test
	 void updateLastNameTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Update last name with new value
		 service.updateLastName(service.getContactList().get(0).getContactId(), lastNameUpdate);
		 
		 // Check updated name is equal to test value
		 assertEquals(lastNameUpdate, service.getContactList().get(0).getLastName());
	 }
	 
	 @DisplayName("Cannot update last name if too long")
	 @Test
	 void updateLastNameIsLongTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Attempt to update last name with name that is too long
		 assertThrows(IllegalArgumentException.class,
				 ()
				 	-> service.updateLastName(service.getContactList().get(0).getContactId(), longLastName));
	 }
	 
	 @DisplayName("Can update phone number")
	 @Test
	 void updatePhoneNumberTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Update phone number with new value
		 service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneUpdate);
		 
		 // Check updated phone is equal to test value
		 assertEquals(phoneUpdate, service.getContactList().get(0).getPhone());
	 }
	 
	 @DisplayName("Phone cannot be longer than 10 digits")
	 @Test
	 void updatePhoneNumberIsLongTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Attempt phone number update with number that is too long
		 assertThrows(IllegalArgumentException.class,
				 ()
				 	-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), longPhone));
	 }
	 
	 @DisplayName("Phone cannot be shorter than 10 digits")
	 @Test
	 void updatePhoneNumberIsShortTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Attempt phone number update with number that is too short
		 assertThrows(IllegalArgumentException.class,
				 ()
				 	-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), shortPhone));
	 }
	 
	 @DisplayName("Can update address")
	 @Test
	 void updateAddressTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Update address with new value
		 service.updateAddress(service.getContactList().get(0).getContactId(), addressUpdate);
		 
		 // Check updated address is equal to test value
		 assertEquals(addressUpdate, service.getContactList().get(0).getAddress());
	 }
	 
	 @DisplayName("Address cannot be longer than 30 characters")
	 @Test
	 void updateAddressIsLongTest() throws Exception {
		 service.newContact(contactId, firstName, lastName, phone, address);
		 
		 // Attempt address update with address that is too long
		 assertThrows(IllegalArgumentException.class,
				 ()
				 	-> service.updateAddress(service.getContactList().get(0).getContactId(), longAddress));
	 }
	 
	 


}
