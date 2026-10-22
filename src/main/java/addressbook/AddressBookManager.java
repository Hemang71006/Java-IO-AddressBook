package addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

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

    // UC9: Get all contacts from every address book that belong to the given city.
    public List<Contact> getContactsByCity(String city) {
        List<Contact> matchingContacts = new ArrayList<>();

        // Visit each address book stored in the manager.
        for (AddressBook addressBook : addressBooks.values()) {

            // Check every contact in the current address book.
            for (Contact contact : addressBook.getContacts()) {

                // Compare city names without case sensitivity.
                if (contact.getCity().equalsIgnoreCase(city)) {
                    matchingContacts.add(contact);
                }
            }
        }

        // Return all contacts found in that city.
        return matchingContacts;
    }

    // UC9: Get all contacts from every address book that belong to the given state.
    public List<Contact> getContactsByState(String state) {
        List<Contact> matchingContacts = new ArrayList<>();

        // Visit each address book stored in the manager.
        for (AddressBook addressBook : addressBooks.values()) {

            // Check every contact in the current address book.
            for (Contact contact : addressBook.getContacts()) {

                // Compare state names without case sensitivity.
                if (contact.getState().equalsIgnoreCase(state)) {
                    matchingContacts.add(contact);
                }
            }
        }

        // Return all contacts found in that state.
        return matchingContacts;
    }

    // UC10: Count contacts that belong to the specified city.
    public long countContactsByCity(String city) {
        long count = 0;

        // Go through every address book managed by this manager.
        for (AddressBook addressBook : addressBooks.values()) {

            // Examine each contact in the current address book.
            for (Contact contact : addressBook.getContacts()) {

                // Count the contact if its city matches, ignoring case.
                if (contact.getCity().equalsIgnoreCase(city)) {
                    count++;
                }
            }
        }

        // Return the total number of matching contacts.
        return count;
    }

    // UC10: Count contacts that belong to the specified state.
    public long countContactsByState(String state) {
        long count = 0;

        // Go through every address book managed by this manager.
        for (AddressBook addressBook : addressBooks.values()) {

            // Examine each contact in the current address book.
            for (Contact contact : addressBook.getContacts()) {

                // Count the contact if its state matches, ignoring case.
                if (contact.getState().equalsIgnoreCase(state)) {
                    count++;
                }
            }
        }

        // Return the total number of matching contacts.
        return count;
    }

    // UC11: Collect contacts from every address book and sort them alphabetically.
    public List<Contact> getContactsSortedAlphabetically() {
        List<Contact> allContacts = new ArrayList<>();

        // Collect contacts from each named address book.
        for (AddressBook addressBook : addressBooks.values()) {
            allContacts.addAll(addressBook.getContacts());
        }

        // Sort by first name; use last name to break ties.
        allContacts.sort(
                Comparator.comparing(Contact::getFirstName,
                                String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contact::getLastName,
                                String.CASE_INSENSITIVE_ORDER)
        );

        // Return the sorted list.
        return allContacts;
    }
}
