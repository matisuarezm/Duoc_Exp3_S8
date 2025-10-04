package exp3_s8_matias_suarez;


import static exp3_s8_matias_suarez.Principal.nombreTeatro;

/**
 * @author msuarez
 */
public class BoletaCompra {
    
    public static void ImprimirBoleta(DatosVenta[] ventasArreglo, int indiceVentas){
        
        //Verificamos que exitan ventas antes de imprimir la boleta
        if (indiceVentas == 0) {
            System.out.println("No existen ventas registradas");
            return;
        }
        
        //buscamos el nombre del ulitmo cliente que compro para imprimir la cantidad de entradas comprada
        Clientes clienteUltimaVenta = ventasArreglo[indiceVentas - 1].nombreCliente; 
        
        System.out.println("\n------------------------------------------");
        System.out.println("                "+ Principal.nombreTeatro +"                ");
        System.out.println("------------------------------------------");
        System.out.println("Cliente: " + clienteUltimaVenta.getNombreCliente());
        System.out.println("Entradas Compradas: ");
        System.out.println("------------------------------------------");
        
        double totalFinal = 0;
        
        //recorremos DatosVenta y chequeamos todas las compras del ultimo cliente = mismo nombre
        for (int i = 0; i < indiceVentas; i++) {
            DatosVenta ventas = ventasArreglo[i];
            if (ventas.nombreCliente == clienteUltimaVenta) {
                System.out.println("Id Venta: " + ventas.idVenta);
                System.out.println("Asiento: " + ventas.numeroAsiento);
                System.out.println("Ubicacion: " + ventas.getUbicacion(Principal.asientosArreglo).toUpperCase());
                System.out.println("Costo Base: " + ventas.precioBase);
                System.out.println("Descuento Aplicado: " + ventas.descuentoAplicado);
                
                totalFinal += ventas.precioFinal;
                }
            
        }
        System.out.println("------------------------------------------");
        System.out.printf("Total a Pagar: $%.2f\n", totalFinal);
        System.out.println("------------------------------------------");
        System.out.println("  Gracias por su visita al " + nombreTeatro);
        System.out.println("------------------------------------------");
    
    }//Fin Imprime Boleta
}
