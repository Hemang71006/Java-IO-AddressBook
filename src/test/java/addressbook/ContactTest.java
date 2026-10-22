package addressbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {

    @Test
    void shouldCreateContactWithProvidedDetails() {
        Contact contact = new Contact(
                "Hemang",
                "Jeswani",
                "Kota",
                "Kota",
                "Rajasthan",
                "324005",
                "9876543210",
                "hemang@example.com"
        );

        assertEquals("Hemang", contact.getFirstName());
        assertEquals("Jeswani", contact.getLastName());
        assertEquals("Kota", contact.getAddress());
        assertEquals("Kota", contact.getCity());
        assertEquals("Rajasthan", contact.getState());
        assertEquals("324005", contact.getZip());
        assertEquals("9876543210", contact.getPhoneNumber());
        assertEquals("hemang@example.com", contact.getEmail());
    }
}
