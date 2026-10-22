package addressbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

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
}
