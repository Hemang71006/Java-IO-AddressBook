# Java I/O Address Book System

A console-based Address Book application developed in Java as part of the BridgeLabz training program. The project is built incrementally through use cases, applying object-oriented programming, Java Collections, Streams, and File I/O.

## Project Objective

To create an Address Book system that allows users to manage contacts, organize multiple address books, search and sort contact details, and persist address-book data using Java File I/O.

## Contact Information

Each contact contains:

- First name
- Last name
- Address
- City
- State
- ZIP code
- Phone number
- Email address

## Use Cases

### UC1 — Create a Contact
Create a contact with first name, last name, address, city, state, ZIP code, phone number, and email.

### UC2 — Add a New Contact
Add a contact to the Address Book using console input and object-oriented relationships between Address Book and Contact.

### UC3 — Edit an Existing Contact
Find a contact by name and edit its details using console input.

### UC4 — Delete a Contact
Delete a contact from the Address Book using the person's name.

### UC5 — Add Multiple Contacts
Add multiple contacts one at a time and maintain them using a Java Collection.

### UC6 — Manage Multiple Address Books
Create multiple uniquely named Address Books and maintain a dictionary mapping Address Book names to Address Book objects.

### UC7 — Prevent Duplicate Contacts
Prevent duplicate entries within an Address Book by checking a person's name, overriding `equals()`, and using Java Streams.

### UC8 — Search Contacts by City or State
Search across multiple Address Books and display contacts belonging to a specified city or state using Java Streams.

### UC9 — View Contacts by City or State
Maintain city-to-contact and state-to-contact dictionaries and use collections and Java Streams to view contacts by location.

### UC10 — Count Contacts by City or State
Display the number of contacts belonging to a specified city or state using Java Streams.

### UC11 — Sort Contacts by Name
Sort Address Book entries alphabetically by a person's name using collections and Java Streams.

### UC12 — Sort Contacts by City, State, or ZIP
Provide sorting functions for contacts by city, state, or ZIP code using the Java Collection Library and Java Streams.

### UC13 — Read and Write Address Book Using File I/O
Read contact information from a file and write Address Book contact information to a file using Java File I/O.

## Planned Project Structure

The project will use a Maven-style Java directory layout:

```text
Java-IO-AddressBook/
├── README.md
├── .gitignore
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── addressbook/
    │           ├── AddressBookMain.java
    │           ├── Contact.java
    │           ├── AddressBook.java
    │           ├── AddressBookManager.java
    │           └── AddressBookFileIO.java
    └── test/
        └── java/
            └── addressbook/
                ├── ContactTest.java
                ├── AddressBookTest.java
                ├── AddressBookManagerTest.java
                └── AddressBookFileIOTest.java
```

## Technologies

- Java
- Object-Oriented Programming
- Java Collections Framework
- Java Streams
- Java File I/O
- Maven
- JUnit
- IntelliJ IDEA
- Git and GitHub

## Git Workflow

- `main` — README and finalized project history
- `develop` — shared project structure and integrated use-case implementation
- `feature/UC1-...` through `feature/UC13-...` — separate branches for individual use cases

Each use case will be developed and tested on its feature branch, then merged into `develop`. The `main` branch will not be updated until the project is ready for final integration.

## Author

Hemang
