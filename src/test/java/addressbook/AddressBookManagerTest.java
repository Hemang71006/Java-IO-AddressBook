package addressbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AddressBookManagerTest {

    @Test
    void shouldCreateAddressBookWithUniqueName() {
        AddressBookManager manager = new AddressBookManager();

        assertTrue(manager.addAddressBook("Family"));
        assertNotNull(manager.getAddressBook("Family"));
    }

    @Test
    void shouldRejectDuplicateAddressBookName() {
        AddressBookManager manager = new AddressBookManager();

        assertTrue(manager.addAddressBook("Family"));
        assertFalse(manager.addAddressBook("Family"));

        assertEquals(1, manager.getAddressBooks().size());
    }

    @Test
    void shouldKeepContactsInSeparateAddressBooks() {
        AddressBookManager manager = new AddressBookManager();
        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact familyContact = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543210", "asha@example.com"
        );

        manager.getAddressBook("Family").addContact(familyContact);

        assertEquals(1, manager.getAddressBook("Family").getContacts().size());
        assertTrue(manager.getAddressBook("Work").getContacts().isEmpty());
    }

    @Test
    void shouldFindContactsByCityAcrossAddressBooks() {
        AddressBookManager manager = new AddressBookManager();

        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact chennaiContact = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543210", "asha@example.com"
        );

        Contact jaipurContact = new Contact(
                "Ravi", "Kumar", "MI Road", "Jaipur",
                "Rajasthan", "302001", "9876543211", "ravi@example.com"
        );

        manager.getAddressBook("Family").addContact(chennaiContact);
        manager.getAddressBook("Work").addContact(jaipurContact);

        List<Contact> results = manager.searchContactsByCity("chennai");

        assertEquals(1, results.size());
        assertSame(chennaiContact, results.get(0));
    }
}
