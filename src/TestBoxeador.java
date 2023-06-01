import java.util.Scanner;

class TestBoxeador {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de boxeadores: ");
        int cantidadBoxeadores = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Boxeador[] boxeadores = new Boxeador[cantidadBoxeadores];

        for (int i = 0; i < cantidadBoxeadores; i++) {
            System.out.println("Boxeador #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();
            System.out.print("Estatura (m): ");
            double estatura = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            boxeadores[i] = new Boxeador(nombre, peso, estatura);
            System.out.println();
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarBoxeadoresPorCategoria(boxeadores);
                    break;
                case 2:
                    buscarContrincantes(boxeadores);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Mostrar boxeadores por categoría");
        System.out.println("2. Buscar contrincantes para un boxeador");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void mostrarBoxeadoresPorCategoria(Boxeador[] boxeadores) {
        System.out.print("Ingrese la categoría (Pesado/P, Crucero/C, Semipesado/S): ");
        String categoria = scanner.nextLine();

        System.out.println("Boxeadores en la categoría " + categoria + ":");
        for (Boxeador boxeador : boxeadores) {
            if (boxeador.getCategoria().equals(categoria)) {
                System.out.println(boxeador);
                System.out.println();
            }
        }
    }

    private static void buscarContrincantes(Boxeador[] boxeadores) {
        System.out.print("Ingrese el índice del boxeador (1-" + boxeadores.length + "): ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (indice >= 1 && indice <= boxeadores.length) {
            Boxeador boxeador = boxeadores[indice - 1];

            System.out.println("Boxeadores en la misma categoría que " + boxeador.getNombre() + " (" + boxeador.getCategoria() + "):");
            for (Boxeador otroBoxeador : boxeadores) {
                if (!otroBoxeador.equals(boxeador) && otroBoxeador.getCategoria().equals(boxeador.getCategoria())) {
                    System.out.println(otroBoxeador);
                    System.out.println("¿" + boxeador.getNombre() + " puede ganarle? " + boxeador.puedeGanarle(otroBoxeador));
                    System.out.println();
                }
            }
        } else {
            System.out.println("Índice inválido. Intente nuevamente.");
        }
    }
}