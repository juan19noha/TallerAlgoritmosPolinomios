package tallerpolinomios;

import java.util.Scanner;

public class TallerPolinomios {

    public static void main(String[] args) {
        menu(true);
    }

    private static void menu(boolean bandera) {
        
        PolinomioF1 Forma1 = new PolinomioF1();
        PolinomioF2 Forma2 = new PolinomioF2();
        PolinomioF3 Forma3 = new PolinomioF3();
        
        Scanner leer = new Scanner(System.in);
        int opcion;
      
        while (bandera) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Ingresar valores para PolF1");
            System.out.println("2. Ingresar valores para PolF2");
            System.out.println("3. Ingresar valores para PolF3");
            System.out.println("4. Sumar PolF1 con PolF3 y obtener PolF2");
            System.out.println("5. Multiplicar PolF3 con PolF2 y obtener PolF1");
            System.out.println("6. Sumar PolF2 con PolF1 y PolF3 y obtener PolF1");
            System.out.println("7. Verificar si PolF2 es simétrico");
            System.out.println("8. Derivar PolF3 y obtener PolF1");
            System.out.println("9. Salir");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    ingresarTermino(Forma1, leer);
                    System.out.println("Polinomio Forma 1: " + Forma1.mostrar());
                    break;
                case 2:
                    ingresarTermino(Forma2, leer);
                    System.out.println("Polinomio Forma 2: " + Forma2.mostrar());
                    break;
                case 3:
                    ingresarTermino(Forma3, leer);
                    System.out.println("Polinomio Forma 3: " + Forma3.mostrar());
                    break;
                case 4:
                    PolinomioF2 sumaF1F3 = Forma1.sumar(Forma3);
                    System.out.println("Resultado de la suma (Forma 1 y Forma 3) en Forma 2: " + sumaF1F3.mostrar());
                    break;
                case 5:
                    PolinomioF1 productoF3F2 = Forma3.multiplicar(Forma2);
                    System.out.println("Resultado de la multiplicación (Forma 3 y Forma 2) en Forma 1: " + productoF3F2.mostrar());
                    break;
                case 6:
                    PolinomioF1 sumaF2F1F3 = Forma2.sumarPolinomios(Forma1, Forma3);
                    System.out.println("Resultado de la suma (Forma 2 con Forma 1 y Forma 3) en Forma 1: " + sumaF2F1F3.mostrar());
                    break;
                case 7:
                    boolean esSimetrico = Forma2.esSimetrico();
                    System.out.println("El polinomio Forma 2 es simétrico: " + esSimetrico);
                    break;
                case 8:
                    PolinomioF1 derivadaF3 = Forma3.derivar();
                    System.out.println("Derivada del polinomio Forma 3 en Forma 1: " + derivadaF3.mostrar());
                    break;
                case 9:
                    bandera = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void ingresarTermino(PolinomioF1 polinomio, Scanner leer) {
        System.out.print("Ingrese coeficiente: ");
        int coef = leer.nextInt();
        System.out.print("Ingrese exponente: ");
        int exp = leer.nextInt();
        polinomio.insertarTermino(coef, exp);
    }

    private static void ingresarTermino(PolinomioF2 polinomio, Scanner leer) {
        System.out.print("Ingrese coeficiente: ");
        int coef = leer.nextInt();
        System.out.print("Ingrese exponente: ");
        int exp = leer.nextInt();
        polinomio.insertarTermino(new Termino(exp, coef));
    }

    private static void ingresarTermino(PolinomioF3 polinomio, Scanner leer) {
        System.out.print("Ingrese coeficiente: ");
        int coef = leer.nextInt();
        System.out.print("Ingrese exponente: ");
        int exp = leer.nextInt();
        polinomio.insertarDesendente(new Nodo(coef, exp));
    }
}