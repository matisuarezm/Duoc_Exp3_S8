package exp3_s8_matias_suarez;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author msuarez
 */ 
public class Principal {

    static String nombreTeatro = "TEATRO MORO";
    static int totalEntradas = 60;
    
    static ArrayList<Eventos> listaDeEventos = new ArrayList<>();
    static Eventos eventoSeleccionado = null;
    
    public static void main(String[] args) throws InterruptedException {
        //Inicializamos los asientos
        Descuentos.inicializarDescuentos();
        
        //Creamos algunos eventos para seleccionar
        listaDeEventos.add(new Eventos("E001", "Las Tortugas Ninjas", "22-10-2025", "12:00", totalEntradas));
        listaDeEventos.add(new Eventos("E002", "Batman V/S Superman", "22-11-2025", "14:00", totalEntradas));
        listaDeEventos.add(new Eventos("E003", "The Avenger EndGame", "22-12-2025", "16:00", totalEntradas));
 
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
                        seleccionarEvento(input);
                        if (eventoSeleccionado != null) {
                            eventoSeleccionado.getGestorVentas().VenderEntradas(input);
                        }
                        break;
                    case 2:
                        if (eventoSeleccionado != null) {
                            BoletaCompra.ImprimirBoleta(
                                    eventoSeleccionado.getGestorVentas().getVentasArreglo(), 
                                    eventoSeleccionado.getGestorVentas().getIndiceVentas(),
                                    eventoSeleccionado.getGestorVentas().getAsientosArreglo());
                        }else{
                            System.err.println("Primero debes seleccionar una evento antes de generar la Boleta");
                        }
                        break;
                    case 3:
                        if (eventoSeleccionado != null) {
                            DatosVenta.CalculaIngresosTotales(eventoSeleccionado.getGestorVentas().getVentasArreglo(), eventoSeleccionado.getGestorVentas().getIndiceVentas());
                        }else{
                            System.err.println("No existen compras para generar este calculo");
                        }
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
                        System.err.println("Opcion Ingresada no es valida, Intente nuevamente");
                }
            }catch(InputMismatchException e){
                System.err.println("Error.. Entrada invalida, Por favor ingrese un numero");
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
    
    public static void seleccionarEvento (Scanner input){
        
        System.out.println("\n====...EVENTOS DISPONIBLES EN CARTELERA...===\n");
        
        //Mostramo los eventos de la lista        
        for (int i = 0; i < listaDeEventos.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeEventos.get(i));
        }
        
        System.out.print("\nSeleccione el numero del Evento: ");
        try{
            int opcionEvento = input.nextInt();
            if (opcionEvento >= 1 && opcionEvento <= listaDeEventos.size()) {
                eventoSeleccionado = listaDeEventos.get(opcionEvento - 1);
                System.out.println("Evento Seleccionado: " + eventoSeleccionado.getNombreEvento() + "\n");
                input.nextLine();
            }else {
                System.out.println("Evento seleccionado no valido");
                eventoSeleccionado = null;
            }
        }catch (Exception e){
            System.out.println("Opcion ingresada invalida");
            input.nextLine();
            eventoSeleccionado = null;
        }
        
    }
}
    