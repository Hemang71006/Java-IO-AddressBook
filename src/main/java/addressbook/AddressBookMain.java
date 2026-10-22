package addressbook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book");

        System.out.println("\nEnter contact details:");
        Contact contact = readContact(scanner);
        addressBook.addContact(contact);

        System.out.print("\nEnter first name of contact to edit: ");
        String searchFirstName = scanner.nextLine();

        System.out.print("Enter last name of contact to edit: ");
        String searchLastName = scanner.nextLine();

        System.out.println("\nEnter updated contact details:");
        Contact updatedContact = readContact(scanner);

        boolean edited = addressBook.editContact(
                searchFirstName, searchLastName, updatedContact
        );

        if (edited) {
            System.out.println("\nContact updated successfully:");
            System.out.println(addressBook.getContact());
        } else {
            System.out.println("\nContact not found.");
        }

        scanner.close();
    }

    private static Contact readContact(Scanner scanner) {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("ZIP: ");
        String zip = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city,
                state, zip, phoneNumber, email);
    }
}
