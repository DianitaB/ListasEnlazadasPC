package view;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n AGENDA DE CONTACTOS");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Mostrar todos los contactos");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingresa un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
