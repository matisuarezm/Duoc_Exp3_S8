package exp3_s8_matias_suarez;


import static exp3_s8_matias_suarez.Principal.nombreTeatro;

/**
 * @author msuarez
 */
public class BoletaCompra {
    
    public static void ImprimirBoleta(DatosVenta[] ventasArreglo, int indiceVentas, Asientos[] asientosEvento){
        
        //Verificamos que exitan ventas antes de imprimir la boleta
        if (indiceVentas == 0) {
            System.out.println("No existen ventas registradas");
            return;
        }   
        
        //buscamos el nombre del ulitmo cliente que compro para imprimir la cantidad de entradas comprada
        Clientes clienteUltimaVenta = ventasArreglo[indiceVentas - 1].getNombreCliente(); 
        
        //Las entradas de la ultima compra
        int cantidadentradas = 0;
        for (int i = 0; i < indiceVentas; i++) {
            if (ventasArreglo[i].getNombreCliente() == clienteUltimaVenta) {
                cantidadentradas++;
            }
        }
        
        //Imprimios la Boleta con todos los datos de la ultima compra realizada por medio del nombre del comprador
        System.out.println("\n------------------------------------------");
        System.out.println("                "+ Principal.nombreTeatro +"                ");
        System.out.println("------------------------------------------");
        System.out.println("Cliente: " + clienteUltimaVenta.getNombreCliente());
        System.out.println("Entradas Compradas: " + cantidadentradas);
        System.out.println("------------------------------------------");
        
        double totalFinal = 0;
        
        //recorremos DatosVenta y chequeamos todas las compras del ultimo cliente = mismo nombre
        for (int i = 0; i < indiceVentas; i++) {
            DatosVenta ventas = ventasArreglo[i];
            if (ventas.getNombreCliente() == clienteUltimaVenta) {
                System.out.println("Id Venta: " + ventas.getIdVenta());
                System.out.println("Asiento: " + ventas.getNumeroAsiento());
                System.out.println("Ubicacion: " + ventas.getUbicacion(asientosEvento).toUpperCase());
                System.out.println("Costo Base: " + ventas.getPrecioBase());
                System.out.println("Descuento Aplicado: " + ventas.getDescuentoAplicado());
                System.out.println("------------------------------------------");
                
                totalFinal += ventas.getPrecioFinal();
                }
            
        }
        System.out.println("------------------------------------------");
        System.out.printf("Total a Pagar: $%.2f\n", totalFinal);
        System.out.println("------------------------------------------");
        System.out.println("  Gracias por su visita al " + nombreTeatro);
        System.out.println("------------------------------------------");
    
    }//Fin Imprime Boleta
}
