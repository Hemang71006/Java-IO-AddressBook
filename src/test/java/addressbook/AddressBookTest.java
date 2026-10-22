package addressbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void shouldAddContactToAddressBook() {
        Contact contact = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(contact);

        assertEquals(1, addressBook.getContacts().size());
        assertSame(contact, addressBook.getContacts().get(0));
    }

    @Test
    void shouldEditContactWhenNameMatches() {
        Contact original = new Contact(
                "Hemang", "Jeswani", "Old Address",
                "Kota", "Rajasthan", "324005",
                "9876543210", "old@example.com"
        );

        Contact updated = new Contact(
                "Hemang", "Jeswani", "New Address",
                "Jaipur", "Rajasthan", "302001",
                "9999999999", "new@example.com"
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(original);

        boolean result = addressBook.editContact(
                "Hemang", "Jeswani", updated
        );

        assertTrue(result);
        assertEquals("New Address",
                addressBook.getContacts().get(0).getAddress());
        assertEquals("Jaipur",
                addressBook.getContacts().get(0).getCity());
        assertEquals("new@example.com",
                addressBook.getContacts().get(0).getEmail());
    }

    @Test
    void shouldNotEditContactWhenNameDoesNotMatch() {
        Contact original = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        Contact updated = new Contact(
                "Other", "Person", "New Address",
                "Jaipur", "Rajasthan", "302001",
                "9999999999", "other@example.com"
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(original);

        boolean result = addressBook.editContact(
                "Unknown", "Person", updated
        );

        assertFalse(result);
        assertEquals("Kota",
                addressBook.getContacts().get(0).getAddress());
    }

    @Test
    void shouldDeleteContactWhenNameMatches() {
        Contact contact = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(contact);

        boolean result = addressBook.deleteContact("Hemang", "Jeswani");

        assertTrue(result);
        assertTrue(addressBook.getContacts().isEmpty());
    }

    @Test
    void shouldNotDeleteContactWhenNameDoesNotMatch() {
        Contact contact = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(contact);

        boolean result = addressBook.deleteContact("Unknown", "Person");

        assertFalse(result);
        assertEquals(1, addressBook.getContacts().size());
        assertSame(contact, addressBook.getContacts().get(0));
    }

    @Test
    void shouldRejectContactWithDuplicateName() {
        AddressBook addressBook = new AddressBook();

        Contact first = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        Contact duplicate = new Contact(
                "hemang", "JESWANI", "Another Address",
                "Jaipur", "Rajasthan", "302001",
                "9999999999", "other@example.com"
        );

        assertTrue(addressBook.addContact(first));
        assertFalse(addressBook.addContact(duplicate));

        assertEquals(1, addressBook.getContacts().size());
    }

    @Test
    void shouldAllowContactsWithDifferentNames() {
        AddressBook addressBook = new AddressBook();

        Contact first = new Contact(
                "Hemang", "Jeswani", "Kota",
                "Kota", "Rajasthan", "324005",
                "9876543210", "hemang@example.com"
        );

        Contact second = new Contact(
                "Hemang", "Sharma", "Jaipur",
                "Jaipur", "Rajasthan", "302001",
                "9999999999", "sharma@example.com"
        );

        assertTrue(addressBook.addContact(first));
        assertTrue(addressBook.addContact(second));

        assertEquals(2, addressBook.getContacts().size());
    }
}