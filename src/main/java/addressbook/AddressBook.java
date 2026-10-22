package addressbook;

public class AddressBook {
    private Contact contact;

    public void addContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }
}
