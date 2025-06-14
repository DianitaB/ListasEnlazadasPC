package controller;

import model.Contact;
import model.Node;
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager = new ContactManager();
    private ConsoleView view = new ConsoleView();

    public void iniciar() {
        contactManager.addContact("Juan Pérez", "0991234567");
        contactManager.addContact("Ana Gómez", "0987654321");
        contactManager.addContact("Carlos Ruiz", "0971122334");
        contactManager.addContact("Lucía Torres", "0969988776");
        contactManager.addContact("Miguel Andrade", "0955544332");

        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    eliminarContacto();
                    break;
                case 4:
                    mostrarContactos();
                    break;
                case 5:
                    view.mostrarMensaje(" ¡Hasta pronto!");
                    break;
                default:
                    view.mostrarMensaje(" Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void agregarContacto() {
        String nombre = view.pedirTexto("Nombre: ");
        String telefono = view.pedirTexto("Teléfono: ");
        contactManager.addContact(nombre, telefono);
        view.mostrarMensaje(" Contacto agregado.");
    }

    private void buscarContacto() {
        String nombre = view.pedirTexto("Nombre a buscar: ");
        Contact contacto = contactManager.findContactByName(nombre);
        if (contacto != null) {
            view.mostrarMensaje(" " + contacto.toString());
        } else {
            view.mostrarMensaje(" Contacto no encontrado.");
        }
    }

    private void eliminarContacto() {
        String nombre = view.pedirTexto("Nombre a eliminar: ");
        boolean eliminado = contactManager.deleteContactByName(nombre);
        if (eliminado) {
            view.mostrarMensaje(" Contacto eliminado.");
        } else {
            view.mostrarMensaje(" Contacto no encontrado.");
        }
    }

    private void mostrarContactos() {
        Node<Contact> actual = contactManager.getContacts().getHead();
        if (actual == null) {
            view.mostrarMensaje("La agenda está vacía.");
        } else {
            while (actual != null) {
                view.mostrarMensaje(actual.getValue().toString());
                actual = actual.getNext();
            }
        }
    }
}
