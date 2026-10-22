package addressbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
