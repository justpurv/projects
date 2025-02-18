import java.util.ArrayList;
import java.util.Scanner;

class contact {
    String name;
    String phone;
    String email;

    public contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name :" + name + " phone :" + phone + " email : " + email;
    }

}

public class contact_manager {

    ArrayList<contact> contacts = new ArrayList<>();
    Scanner c = new Scanner(System.in);

    public void addContact(ArrayList<contact> contacts, Scanner c) {
        System.out.println("enter name :");
        String name = c.nextLine();

        System.out.println("enter phone :");
        String phone = c.nextLine();

        System.out.println("enter email :");
        String email = c.nextLine();

        contact newContact = new contact(name, phone, email);
        contacts.add(newContact);
        System.out.println("contact added successfully!!!");

    }

    public void searchContact(ArrayList<contact> contacts, Scanner c) {
        System.out.println("enter name or phone to search :");
        String query = c.nextLine();
        boolean found = false;

        for (contact contact : contacts) {
            if (contact.getName().equals(query) || contact.getPhone().equals(query)) {
                System.out.println("contact found!!" + contact);
                found = true;
                break;
            }
            if (!found) {
                System.out.println("contact is not in the list!!");
            }
        }
    }

    public void updateContact(ArrayList<contact> contacts, Scanner c) {
        System.out.println("enter name or phone  to update information :");
        String query = c.nextLine();
        boolean found = false;

        for (contact contact : contacts) {
            if (contact.getName().equals(query) || contact.getPhone().equals(query)) {
                System.out.println("enter new name :");
                String newName = c.nextLine();

                System.out.println("enter new phone :");
                String newPhone = c.nextLine();

                System.out.println("enter new email :");
                String newEmail = c.nextLine();

                if (!newName.isEmpty()) {
                    contact.setName(newName);
                }

                if (!newPhone.isEmpty()) {
                    contact.setPhone(newPhone);
                }

                if (!newEmail.isEmpty()) {
                    contact.setEmail(newEmail);
                }
                System.out.println("contact updated successfully :");
                found = true;
                break;
            }
            if (!found) {
                System.out.println("contact is not in the list!!");
            }
        }
    }

    public static void displayAllContacts(ArrayList<contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\n--- Contact List ---");
            for (contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(ArrayList<contact> contacts, Scanner c) {
        System.out.println("delete name or phone of contact to delete :");
        String query = c.nextLine();
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            contact con = contacts.get(i);

            if (con.getName().equals(query) || con.getPhone().equals(query)) {
                contacts.remove(i);
                System.out.println("removed successfully!!");
                found = true;
                break;
            }
            if (!found) {
                System.out.println("contact not found!!!");
            }
        }
    }

    public void run() {
        /*
         * features
         * 1 add contacts
         * 2 seartch contact
         * 3 update contact
         * 4 delete contact
         * 5 display all contacts
         * 6 exit
         */

        boolean running = true;
        System.out.println("\n--- Contact Manager Menu ---");
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Display All Contacts");
        System.out.println("6. Exit");

        while (running) {
            System.out.println("enter your choice: ");
            int choice = c.nextInt();
            c.nextLine();

            switch (choice) {
                case 1:
                    addContact(contacts, c);
                    break;

                case 2:
                    searchContact(contacts, c);
                    break;

                case 3:
                    updateContact(contacts, c);

                case 4:
                    deleteContact(contacts, c);
                    break;

                case 5:
                    displayAllContacts(contacts);
                    break;

                case 6:
                    running = false;
                    System.out.println("exit");

                default:
                    System.out.println("404");

            }
        }
        c.close();

    }

    public static void main(String[] args) {
        contact_manager con = new contact_manager();
        con.run();
    }

}