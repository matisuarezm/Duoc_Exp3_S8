package exp3_s8_matias_suarez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author msuarez
 */ 
public class Principal {

    static String nombreTeatro = "TEATRO MORO";
    static int totalEntradas = 50;
    
    static DatosVenta[] ventasArreglo = new DatosVenta[totalEntradas];
    static Asientos[] asientosArreglo = new Asientos[totalEntradas];
    static Clientes[] clientesArreglo = new Clientes[totalEntradas];
    
    static VendeEntradas gestorVentas;
    
    public static void main(String[] args) throws InterruptedException {
        //Inicializamos los asientos
        Asientos.inicializarAsientos(asientosArreglo);
        
        //inicializamos los Descuentos
        Descuentos.inicializarDescuentos();
        
        //gestor para ventas
        gestorVentas = new VendeEntradas(ventasArreglo, asientosArreglo, clientesArreglo, totalEntradas);
 
        Scanner input = new Scanner(System.in);
        System.out.println("====--->>> BIENVENIDOS AL EXPECTACULAR " + nombreTeatro + " <<<---====");
        
        int opcionMenu;
        do{
            MostrarMenu();
            try{
                opcionMenu = input.nextInt();
                input.nextLine();

                switch(opcionMenu){
                    case 1:
                        gestorVentas.VenderEntradas(input);
                        break;
                    case 2:
                        BoletaCompra.ImprimirBoleta(ventasArreglo, gestorVentas.getIndiceVentas());
                        break;
                    case 3:
                        DatosVenta.CalculaIngresosTotales(ventasArreglo, gestorVentas.getIndiceVentas());
                        break;
                    case 4:
                        System.out.println("Usted esta saliendo del sistema");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(900);
                                System.out.print(".");
                            }
                            System.out.println("\nMuchas gracias por su compra.!!!!");
                            System.out.println("");
                            break;
                    default:
                        System.out.println("Opcion Ingresada no es valida, Intente nuevamente");
                }
            }catch(InputMismatchException e){
                System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
                input.nextLine();
                opcionMenu = 0;
            }
        }while(opcionMenu != 4);
        
    }//Fin del Principal (Main)
    
    public static void MostrarMenu(){        
        
        System.out.println("\n===... MEMÚ PRINCIPAL " + nombreTeatro + " ...===");
        System.out.println("1.- Venta de Entradas");
        System.out.println("2.- Generar Boleta");
        System.out.println("3.- Calcular Ingresos Totales");
        System.out.println("4.- Salir");
        System.out.print("\nSeleccione una opcion del Menú: ");
    
    }//Fin MostrarMenu()
    
}
