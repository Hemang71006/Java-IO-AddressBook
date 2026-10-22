package addressbook;

import java.io.*;
import java.util.List;

public class AddressBookFileIO {

    // Save the contacts list into a file.
    public void saveContacts(List<Contact> contacts, String fileName)
            throws IOException {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            output.writeObject(contacts);
        }
    }

    // Read the contacts list back from the file.
    @SuppressWarnings("unchecked")
    public List<Contact> loadContacts(String fileName)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            return (List<Contact>) input.readObject();
        }
    }
}
