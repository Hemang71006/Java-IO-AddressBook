package addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManager {
    private final Map<String, AddressBook> addressBooks = new HashMap<>();

    public boolean addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            return false; // Name already exists
        }

        addressBooks.put(name, new AddressBook());
        return true;
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public Map<String, AddressBook> getAddressBooks() {
        return addressBooks;
    }

    public List<Contact> searchContactsByCity(String city) {
        List<Contact> matchingContacts = new ArrayList<>();

        for (AddressBook addressBook : addressBooks.values()) {
            for (Contact contact : addressBook.getContacts()) {
                if (contact.getCity().equalsIgnoreCase(city)) {
                    matchingContacts.add(contact);
                }
            }
        }

        return matchingContacts;
    }
}
