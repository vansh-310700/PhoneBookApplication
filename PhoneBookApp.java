package PhonebookApplication;

import java.util.Scanner;

public class PhoneBookApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhoneBook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Display Contacts (Alphabetical Order)");
            System.out.println("6. Display Contacts (Original Order)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    if (!Validation.isValidPhoneNumber(phone)) {
                        System.out.println("Error: Invalid phone number. Must be 10 digits.");
                        break;
                    }
                    if (!Validation.isValidEmail(email)) {
                        System.out.println("Error: Invalid email format.");
                        break;
                    }

                    Contact contact = new Contact(name, phone, email, address);
                    phoneBook.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter name of the contact to edit: ");
                    String editName = scanner.nextLine();
                    phoneBook.editContact(editName, scanner);
                    break;

                case 3:
                    System.out.print("Enter name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    phoneBook.deleteContact(deleteName);
                    break;

                case 4:
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    phoneBook.searchContacts(query);
                    break;

                case 5:
                    phoneBook.displayContacts(true);
                    break;

                case 6:
                    phoneBook.displayContacts(false);
                    break;

                case 7:
                    System.out.println("Exiting PhoneBook application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

