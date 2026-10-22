package addressbook;

import java.util.HashMap;
import java.util.Map;

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
}
