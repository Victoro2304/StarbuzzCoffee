package org.itson.arquitecturasoftware.starbuzz;

import bebidas.DarkRoast;
import bebidas.Decaf;
import bebidas.Expresso;
import bebidas.HouseBlend;
import bebidas.IBeverage;
import condimentos.ChocolateDecorator;
import condimentos.MilkDecorator;
import condimentos.SoyDecorator;
import condimentos.WhippedCreamDecorator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que permite desplegar un menú con el cual el usuario puede
 * interactuar para realizar un pedido.
 *
 * @author Víctor Humberto Encinas Guzmán 00000244821
 */
public class StarBuzz {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        List<IBeverage> orden = new ArrayList<>();
        boolean continuar = true;

        System.out.println("Bienvenido a Starbuzz Coffee:");

        do {
            IBeverage beverage = seleccionarBebida(tec);
            beverage = agregarCondimentos(tec, beverage);

            orden.add(beverage);

            System.out.println("\n¿Desea continuar agregando otra bebida? (s/n)");
            System.out.print("Respuesta: ");
            String respuesta = tec.next();

            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        } while (continuar);

        mostrarResumenCompra(orden);
    }

    /**
     * Permite que el usuario seleccione una bebida del menú
     *
     * @param scanner objeto de Scanner para capturar los datos.
     * @return instancia de IBeverage de la bebida seleccionada.
     */
    public static IBeverage seleccionarBebida(Scanner scanner) {
        boolean bebidaSeleccionada = false;
        IBeverage beverage = null;

        do {
            System.out.println("\nSeleccione una bebida:");
            System.out.println("1. House Blend");
            System.out.println("2. Dark Roast");
            System.out.println("3. Expresso");
            System.out.println("4. Decaf");

            System.out.print("Opcion: ");
            int seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    beverage = new HouseBlend();
                    bebidaSeleccionada = true;
                    break;
                case 2:
                    beverage = new DarkRoast();
                    bebidaSeleccionada = true;
                    break;
                case 3:
                    beverage = new Expresso();
                    bebidaSeleccionada = true;
                    break;
                case 4:
                    beverage = new Decaf();
                    bebidaSeleccionada = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!bebidaSeleccionada);

        return beverage;
    }

    /**
     * Permite que el usuario agregue condimentos a la bebida seleccionada.
     *
     * @param scanner objeto de Scanner para capturar los datos.
     * @param beverage bebida a la cual se le agregarán los condimentos.
     * @return instancia de IBeverage de la bebida seleccionada y con los
     * condimentos agregados.
     */
    public static IBeverage agregarCondimentos(Scanner scanner, IBeverage beverage) {
        boolean agregarCondimentos = true;

        do {
            System.out.println("\nElige un condimento:");
            System.out.println("1. Leche");
            System.out.println("2. Leche de soya");
            System.out.println("3. Crema batida");
            System.out.println("4. Chocolate");
            System.out.println("5. Ninguno");

            System.out.print("Opcion: ");
            int seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    beverage = new MilkDecorator(beverage);
                    break;
                case 2:
                    beverage = new SoyDecorator(beverage);
                    break;
                case 3:
                    beverage = new WhippedCreamDecorator(beverage);
                    break;
                case 4:
                    beverage = new ChocolateDecorator(beverage);
                    break;
                case 5:
                    agregarCondimentos = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (agregarCondimentos != false) {
                System.out.println("\n¿Desea agregar más condimentos? (s/n)");
                System.out.print("Respuesta: ");
                String respuesta = scanner.next();

                if (respuesta.equalsIgnoreCase("n")) {
                    agregarCondimentos = false;
                }
            }
        } while (agregarCondimentos);

        return beverage;
    }

    /**
     * Permite mostrar el resumen del pedido final, las bebidas y sus costos,
     * además del costo total del pedido.
     *
     * @param orden lista de bebidas ordenadas.
     */
    public static void mostrarResumenCompra(List<IBeverage> orden) {
        float total = 0.0f;

        System.out.println("\nResumen del pedido:");
        for (IBeverage bebida : orden) {
            System.out.println("| " + bebida.getDescripcion() + ": $" + bebida.getCosto() + " |");
            total += bebida.getCosto();
        }

        System.out.println("Total: $" + total);
    }
}
