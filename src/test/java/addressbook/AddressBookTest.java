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

        assertSame(contact, addressBook.getContact());
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
        assertEquals("New Address", addressBook.getContact().getAddress());
        assertEquals("Jaipur", addressBook.getContact().getCity());
        assertEquals("new@example.com", addressBook.getContact().getEmail());
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
        assertEquals("Kota", addressBook.getContact().getAddress());
    }
}