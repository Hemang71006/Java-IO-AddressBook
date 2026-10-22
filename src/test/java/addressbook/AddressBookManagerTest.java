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

    @Test
    void shouldGetContactsByCityAcrossAddressBooks() {
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

        List<Contact> results = manager.getContactsByCity("Chennai");

        assertEquals(1, results.size());
        assertSame(chennaiContact, results.get(0));
    }

    @Test
    void shouldGetContactsByStateAcrossAddressBooks() {
        AddressBookManager manager = new AddressBookManager();
        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact firstRajasthanContact = new Contact(
                "Hemang", "Jeswani", "Kota", "Kota",
                "Rajasthan", "324005", "9876543210", "hemang@example.com"
        );

        Contact secondRajasthanContact = new Contact(
                "Ravi", "Kumar", "MI Road", "Jaipur",
                "Rajasthan", "302001", "9876543211", "ravi@example.com"
        );

        Contact tamilNaduContact = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543212", "asha@example.com"
        );

        manager.getAddressBook("Family").addContact(firstRajasthanContact);
        manager.getAddressBook("Work").addContact(secondRajasthanContact);
        manager.getAddressBook("Work").addContact(tamilNaduContact);

        List<Contact> results = manager.getContactsByState("rajasthan");

        assertEquals(2, results.size());
        assertTrue(results.contains(firstRajasthanContact));
        assertTrue(results.contains(secondRajasthanContact));
    }

    @Test
    void shouldCountContactsByCityAcrossAddressBooks() {
        AddressBookManager manager = new AddressBookManager();
        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact chennaiContact1 = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543210", "asha@example.com"
        );

        Contact chennaiContact2 = new Contact(
                "Ravi", "Kumar", "Anna Nagar", "Chennai",
                "Tamil Nadu", "600002", "9876543211", "ravi@example.com"
        );

        Contact jaipurContact = new Contact(
                "Neha", "Singh", "MI Road", "Jaipur",
                "Rajasthan", "302001", "9876543212", "neha@example.com"
        );

        manager.getAddressBook("Family").addContact(chennaiContact1);
        manager.getAddressBook("Work").addContact(chennaiContact2);
        manager.getAddressBook("Work").addContact(jaipurContact);

        assertEquals(2, manager.countContactsByCity("chennai"));
    }

    @Test
    void shouldCountContactsByStateAcrossAddressBooks() {
        AddressBookManager manager = new AddressBookManager();
        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact rajasthanContact1 = new Contact(
                "Hemang", "Jeswani", "Kota", "Kota",
                "Rajasthan", "324005", "9876543210", "hemang@example.com"
        );

        Contact rajasthanContact2 = new Contact(
                "Ravi", "Kumar", "MI Road", "Jaipur",
                "Rajasthan", "302001", "9876543211", "ravi@example.com"
        );

        Contact tamilNaduContact = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543212", "asha@example.com"
        );

        manager.getAddressBook("Family").addContact(rajasthanContact1);
        manager.getAddressBook("Work").addContact(rajasthanContact2);
        manager.getAddressBook("Work").addContact(tamilNaduContact);

        assertEquals(2, manager.countContactsByState("RAJASTHAN"));
    }

    @Test
    void shouldReturnContactsInAlphabeticalOrder() {
        AddressBookManager manager = new AddressBookManager();
        manager.addAddressBook("Family");
        manager.addAddressBook("Work");

        Contact ravi = new Contact(
                "Ravi", "Kumar", "MI Road", "Jaipur",
                "Rajasthan", "302001", "9876543211", "ravi@example.com"
        );

        Contact asha = new Contact(
                "Asha", "Sharma", "MG Road", "Chennai",
                "Tamil Nadu", "600001", "9876543210", "asha@example.com"
        );

        Contact hemang = new Contact(
                "Hemang", "Jeswani", "Kota", "Kota",
                "Rajasthan", "324005", "9876543212", "hemang@example.com"
        );

        manager.getAddressBook("Family").addContact(ravi);
        manager.getAddressBook("Work").addContact(asha);
        manager.getAddressBook("Family").addContact(hemang);

        List<Contact> sorted = manager.getContactsSortedAlphabetically();

        assertEquals(3, sorted.size());
        assertSame(asha, sorted.get(0));
        assertSame(hemang, sorted.get(1));
        assertSame(ravi, sorted.get(2));
    }

    @Test
    void contactsShouldBeSortedByCity() {
        AddressBookManager manager = new AddressBookManager();
        AddressBook book = new AddressBook();

        book.addContact(new Contact(
                "Ravi", "Kumar", "Street 1", "Chennai",
                "Tamil Nadu", "600001", "111", "ravi@example.com"
        ));

        book.addContact(new Contact(
                "Asha", "Sharma", "Street 2", "Bengaluru",
                "Karnataka", "560001", "222", "asha@example.com"
        ));

        manager.addAddressBook("Friends");
        manager.getAddressBook("Friends").addContact(
                book.getContacts().get(0)
        );
        manager.getAddressBook("Friends").addContact(
                book.getContacts().get(1)
        );

        List<Contact> sorted = manager.sortByCity();

        assertEquals("Bengaluru", sorted.get(0).getCity());
        assertEquals("Chennai", sorted.get(1).getCity());
    }
}
