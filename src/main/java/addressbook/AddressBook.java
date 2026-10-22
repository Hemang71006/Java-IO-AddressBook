package addressbook;

public class AddressBook {
    private Contact contact;

    public void addContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public boolean editContact(String firstName, String lastName,
                               Contact updatedContact) {
        if (contact != null
                && contact.getFirstName().equalsIgnoreCase(firstName)
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

        return false;
    }
}
