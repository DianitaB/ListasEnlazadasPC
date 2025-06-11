package controller;

import model.Contact;
import model.LinkedList;
import model.Node;

public class ContactManager {
    private LinkedList<Contact> contacts = new LinkedList<>();

    public void addContact(String name, String phone) {
        contacts.appendToTail(new Contact(name, phone));  
    }

    public Contact findContactByName(String name) {
        Node<Contact> current = contacts.getHead();
        while (current != null) {
            Contact c = current.getValue();
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean deleteContactByName(String name) {
        Node<Contact> current = contacts.getHead();
        while (current != null) {
            Contact c = current.getValue();
            if (c.getName().equalsIgnoreCase(name)) {
                contacts.deleteByValue(c);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public LinkedList<Contact> getContacts() {
        return contacts;
    }
}
