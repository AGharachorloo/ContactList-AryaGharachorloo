import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person contact) {
        contacts.add(contact);
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sortBy(int sortStyle) {

        for (int i = 0; i < contacts.size()-1; i++) {
            for (int j = 0; j < contacts.size() - 1 - i; j++) {
                if (sortStyle == 0) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) < 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, temp);
                    }
                } else if (sortStyle == 1) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) < 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                } else if (sortStyle == 2) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) < 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name" +
                    "\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n" +
                    "7. Search By Last Name\n8.Search By Phone Number\n0. Exit");
            int response = input.nextInt();
            input.nextLine();
            switch(response) {
                case 0:
                    break;
                case 1:
                    System.out.println("Select a type of contact to add:\n1. Student\n2. Teacher");
                    int contactType = input.nextInt();
                    System.out.println("Please fill in the following information");
                    System.out.println("First Name:");
                    String firstName = input.nextLine();
                    System.out.println("Last Name:");
                    String lastName = input.nextLine();
                    System.out.println("Phone Number:");
                    String phoneNumber = input.nextLine();
                    if (contactType == 1) {
                        System.out.println("Grade:");
                        int grade = input.nextInt();
                        input.nextLine();
                        Student newContact = new Student(firstName, lastName, phoneNumber, grade);
                        contacts.add(newContact);
                    }
                    else {
                        System.out.println("Subject");
                        String subject = input.nextLine();
                        Teacher newContact = new Teacher(firstName, lastName, phoneNumber, subject);
                        contacts.add(newContact);
                    }
                case 2:
                    sortBy(0);
                    printContacts();
                case 3:
                    sortBy(1);
                    printContacts();
                case 4:
                    sortBy(2);
                    printContacts();
                case 5:
                    listStudents();
                case 6:
                    System.out.println("Enter a first name:");
                    String searchFirstName = input.nextLine();
                    searchByFirstName(searchFirstName);
                case 7:
                    System.out.println("Enter a last name:");
                    String searchLastName = input.nextLine();
                    searchByLastName(searchLastName);
            }
        }

    }
}