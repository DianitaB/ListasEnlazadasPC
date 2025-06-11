package controller;

import model.Contact;
import model.LinkedList;

public class ContactManager {
    private LinkedList<Contact<String, String>> contacts = new LinkedList<>();

    public void addContact(String name, String phone) {
        contacts.appendToTail(new Contact<>(name, phone));
    }

    public Contact<String, String> findContactByName(String name) {
        for (int i = 0; i < contacts.getSize(); i++) {
            Contact<String, String> c = contacts.getHead().getValue();
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteContactByName(String name) {
        for (int i = 0; i < contacts.getSize(); i++) {
            Contact<String, String> c = contacts.getHead().getValue();
            if (c.getName().equalsIgnoreCase(name)) {
                contacts.deleteByValue(c);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Contact<String, String>> getContacts() {
        return contacts;
    }
}

