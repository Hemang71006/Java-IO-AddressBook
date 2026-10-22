package addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

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

        System.out.println(contact);
    }
}
