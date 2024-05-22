import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Crear empleado.");
            System.out.println("2. Listar empleados.");
            System.out.println("3. Borrar empleado por DNI.");
            System.out.println("4. Salir.");
            System.out.print("Ingrese una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese DNI: ");
                    String DNI = scanner.nextLine();
                    System.out.print("Ingrese número de empleado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.next();
                    }
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    Empleado empleado = new Empleado(nombre, DNI, numero);
                    empleados.add(empleado);
                    System.out.println("Empleado creado.");
                    break;
                case 2:
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados para listar.");
                    } else {
                        for (Empleado emp : empleados) {
                            System.out.println("Nombre: " + emp.getNombre());
                            System.out.println("DNI: " + emp.getDNI());
                            System.out.println("Número de empleado: " + emp.getNumero());
                            System.out.println("Media del portfolio: " + emp.getPortfolio().media());
                            System.out.println("-----");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese DNI del empleado a borrar: ");
                    String DNI_borrar = scanner.nextLine();
                    boolean encontrado = empleados.removeIf(emp -> emp.getDNI().equals(DNI_borrar));
                    if (encontrado) {
                        System.out.println("Empleado borrado.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}