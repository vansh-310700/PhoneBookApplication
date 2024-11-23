package PhonebookApplication;

import java.util.*;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(contact.getName())) {
                System.out.println("Error: Contact with the same name already exists.");
                return false;
            }
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) {
                System.out.println("Error: Contact with the same phone number already exists.");
                return false;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully.");
        return true;
    }

    public boolean editContact(String name, Scanner scanner) {
        Contact contact = findContactByName(name);
        if (contact == null) {
            System.out.println("Error: Contact not found.");
            return false;
        }

        System.out.print("Enter new phone number: ");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.print("Enter new email: ");
        contact.setEmail(scanner.nextLine());
        System.out.print("Enter new address: ");
        contact.setAddress(scanner.nextLine());

        System.out.println("Contact updated successfully.");
        return true;
    }

    public boolean deleteContact(String name) {
        Contact contact = findContactByName(name);
        if (contact == null) {
            System.out.println("Error: Contact not found.");
            return false;
        }
        contacts.remove(contact);
        System.out.println("Contact deleted successfully.");
        return true;
    }

    public void searchContacts(String query) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(query) ||
                    contact.getPhoneNumber().equals(query) ||
                    contact.getEmail().equalsIgnoreCase(query) ||
                    contact.getAddress().equalsIgnoreCase(query)) {
                results.add(contact);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No contacts found matching the query.");
        } else {
            System.out.println("Search Results:");
            for (Contact contact : results) {
                System.out.println(contact);
            }
        }
    }

    public void displayContacts(boolean alphabetical) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }

        if (alphabetical) {
            Collections.sort(contacts);
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}

