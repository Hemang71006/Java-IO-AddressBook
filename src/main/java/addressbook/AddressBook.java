package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    public boolean addContact(Contact contact) {
        if (isDuplicateContact(contact)) {
            return false;
        }

        contacts.add(contact);
        return true;
    }

    // Return all contacts
    public List<Contact> getContacts() {
        return contacts;
    }

    // UC3: Edit a contact by name
    public boolean editContact(String firstName, String lastName,
                               Contact updatedContact) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {

                contact.setFirstName(updatedContact.getFirstName());
                contact.setLastName(updatedContact.getLastName());
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());

                return true;
            }
        }

        return false;
    }

    // UC4: Delete a contact by name
    public boolean deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public boolean isDuplicateContact(Contact newContact) {
        return contacts.stream().anyMatch(existingContact ->
                existingContact.getFirstName().equalsIgnoreCase(
                        newContact.getFirstName())
                        && existingContact.getLastName().equalsIgnoreCase(
                        newContact.getLastName()));
    }
}