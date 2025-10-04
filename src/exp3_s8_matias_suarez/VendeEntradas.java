package exp3_s8_matias_suarez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author msuarez
 */
public class VendeEntradas {
     
    private DatosVenta[] ventasArreglo;
    private Asientos[] asientosArreglo;
    private Clientes[] clientesArreglo;
    private int totalEntradas;
    
    private int indiceVentas;
    private int indiceClientes;
    private int indiceAsientosDisponibles;
    
    public VendeEntradas(DatosVenta[] ventasArreglo, Asientos[] asientosArreglo,Clientes[] clientesArreglo, int totalEntradas){
        this.ventasArreglo = ventasArreglo;
        this.asientosArreglo = asientosArreglo;
        this.clientesArreglo = clientesArreglo;
        this.totalEntradas = totalEntradas;
        
        this.indiceVentas = 0;
        this.indiceClientes = 0;
        this.indiceAsientosDisponibles = totalEntradas;
        
        //Inicializamos asientos segun la ubicacion
        for (int i = 0; i < totalEntradas; i++) {
            asientosArreglo[i] = new Asientos(i + 1, true);
        }
    }    
     
    public void VenderEntradas(Scanner input){
        if (indiceVentas >= totalEntradas) {
            System.out.println("No hay mas entradas disponibles a la venta. ");
            return;
        }
        
        //Registro de Cliente
        System.out.print("Ingrese su Nombre: ");
        String nombreCliente = input.nextLine().trim();
        
        Clientes nuevoCliente = new Clientes("IDC" + (indiceClientes + 1), nombreCliente);
        clientesArreglo[indiceClientes++] = nuevoCliente;
                        
        //Seleccion de Ubicacion
        System.out.print("Seleccione la ubicacion deseada (");
        System.out.println(String.join(", ", Asientos.ubicacionesDisponibles()) + "): ");
        String ubicacion = input.nextLine().trim().toLowerCase();

        if (!Asientos.ubicacionValida(ubicacion)) {
            System.out.println("Ubicacion ingresada no es válida.");
            return;
        }
        
        //Tipo de Cliente
        System.out.print("Indique su tipo de Cliente (general, estudiante, TerceraEdad): ");
        String tipoClienteUsuario = input.nextLine().trim().toLowerCase();
        
        if (!Descuentos.TipoDescuentoValido(tipoClienteUsuario)) {
            System.out.println("Tipo de cliente ingresado no es Válido, se asumirá general");
            tipoClienteUsuario = "general";
        }
        
        //Buscamos asientos disponibles
        int asientosDisponible = 0;
        for (Asientos asiento : asientosArreglo) {
            if (asiento.isEstadoAsiento() && asiento.getUbicacion().equalsIgnoreCase(ubicacion)) {
                asientosDisponible  ++;
            }
        }
        
        if (asientosDisponible == 0) {
            System.out.println("No hay asientos disponibles.");
            return;
        }
        
        //Consultamos la cantidad de entradas a comprar
        int cantidadEntradas = 0;
        while (true) {
            System.out.printf("Ingrese la cantidad de entradas a comprar (máximo %d): ", asientosDisponible);
            try {
                cantidadEntradas = input.nextInt();
                input.nextLine();
                if (cantidadEntradas > 0 && cantidadEntradas <= asientosDisponible) {
                    break;
                } else {
                    System.out.println("Cantidad inválida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                input.nextLine();
                continue;
            }
        }
        
        //Mostramos los asientos por ubicacion
        mostrarAsientos(ubicacion);
        
        //Seleccionamos los asientos a comprar y guardamos en una lista las compras para dar los totales
        List<DatosVenta> ventaParcial = new ArrayList<>(); 
        double totalParcial = 0;
        
        for (int i = 0; i < cantidadEntradas; i++) {
           int asientoNumero = -1;
            while (true) {
                System.out.printf("Ingrese el número de asiento %d a comprar: ", i + 1);
                try {
                    asientoNumero = input.nextInt();
                    input.nextLine();
                    if (asientoNumero < 1 || asientoNumero > totalEntradas) {
                        System.out.println("Número de asiento inválido. Intente de nuevo.");
                        continue;
                    }
                    Asientos asientoElegido = asientosArreglo[asientoNumero - 1];
                    if (!asientoElegido.isEstadoAsiento()) {
                        System.out.println("Asiento no disponible. Intente de nuevo.");
                        continue;
                    }
                    if (!asientoElegido.getUbicacion().equalsIgnoreCase(ubicacion)) {
                        System.out.println("El asiento no corresponde a la ubicación seleccionada. Intente de nuevo.");
                        continue;
                    }
                    // Registrar la venta
                    double precioBase = DatosVenta.TraePrecioBase(ubicacion);
                    double porcentajeDescuento = Descuentos.obtenerDescuentos(tipoClienteUsuario);
                    double descuentoAplicado = precioBase * porcentajeDescuento;
                    double precioFinal = precioBase - descuentoAplicado;

                    //Guardamos la venta en el arreglo parcial
                    DatosVenta nuevaVenta = new DatosVenta("IDV" + (indiceVentas + 1), nuevoCliente, precioBase, descuentoAplicado, precioFinal, asientoNumero);
                    ventaParcial.add(nuevaVenta);

                    //Cambiamos el estado del asiento elegido
                    asientoElegido.setDisponible(false);
                    indiceAsientosDisponibles--;
                    
                    totalParcial += precioFinal;

                    System.out.println("Asiento registrado exitosamente.");
                    System.out.printf("Asiento asignado: %d\n", asientoNumero);
                    System.out.printf("Total a cancelar por asiento: $%.2f\n\n", precioFinal);

                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Intente de nuevo.");
                    input.nextLine();
                }
            }
        }
        
        //Agregamos los datos de compra al arreglo principal DatosVenta
        for (DatosVenta venta : ventaParcial) {
            venta.idVenta = "IDV" + (indiceVentas +1);
            ventasArreglo[indiceVentas++] = venta;
        }
        
        System.out.printf("El total a cancelar por los %d asientos comprados: $%.2f\n", cantidadEntradas, totalParcial);
    }
        
    public void mostrarAsientos(String ubicacion) {
        System.out.println("\nEstado de asientos para ubicación: " + ubicacion.toUpperCase() + " (Libre = [L], Ocupado = [X])");
        int contador = 0;
        for (int i = 0; i < totalEntradas; i++) {
            Asientos asiento = asientosArreglo[i];
            if (asiento.getUbicacion().equalsIgnoreCase(ubicacion)) {
                String estado = asiento.isEstadoAsiento() ? "[L]" : "[X]"; // L = Libre, X = Ocupado
                System.out.printf("%3d %s  ", asiento.getNumeroAsiento(), estado);
                contador++;
                if (contador % 5 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public int getIndiceVentas() {
        return indiceVentas;
    }
    
    
    
}
