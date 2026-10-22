package addressbook;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookFileIOTest {

    @Test
    void shouldSaveAndLoadContacts() throws Exception {
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact(
                "Hemang", "Jeswani", "Street 1", "Chennai",
                "Tamil Nadu", "600001", "1234567890", "hemang@example.com"
        ));

        AddressBookFileIO fileIO = new AddressBookFileIO();
        String fileName = "test-addressbook.dat";

        fileIO.saveContacts(contacts, fileName);
        List<Contact> loadedContacts = fileIO.loadContacts(fileName);

        assertEquals(1, loadedContacts.size());
        assertEquals("Hemang", loadedContacts.get(0).getFirstName());

        new File(fileName).delete();
    }
}
