import java.util.ArrayList;
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
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) ==) {

                    }
                } else if (sortStyle == 1) {
                } else if (sortStyle == 2) {
                }
            }
        }
    }
}