package addressbook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book");

        // UC5: Add multiple contacts
        String choice;

        do {
            System.out.println("\nEnter contact details:");
            Contact contact = readContact(scanner);

            boolean added = addressBook.addContact(contact);

            if (added) {
                System.out.println("Contact added successfully.");
            } else {
                System.out.println("A contact with this first and last name already exists.");
            }

            System.out.print("Add another contact? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\nContacts in Address Book:");
        for (Contact savedContact : addressBook.getContacts()) {
            System.out.println(savedContact);
        }

        // UC3: Edit a contact
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
        } else {
            System.out.println("\nContact not found.");
        }

        // UC4: Delete a contact
        System.out.print("\nEnter first name of contact to delete: ");
        String deleteFirstName = scanner.nextLine();

        System.out.print("Enter last name of contact to delete: ");
        String deleteLastName = scanner.nextLine();

        boolean deleted = addressBook.deleteContact(
                deleteFirstName, deleteLastName
        );

        if (deleted) {
            System.out.println("\nContact deleted successfully.");
        } else {
            System.out.println("\nContact not found.");
        }

        // Display remaining contacts
        System.out.println("\nRemaining contacts:");
        for (Contact savedContact : addressBook.getContacts()) {
            System.out.println(savedContact);
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