package exp3_s8_matias_suarez;

/**
 *
 * @author msuarez
 */
public class DatosVenta {
    String idVenta;
    Clientes nombreCliente;
    double precioBase;
    double descuentoAplicado;
    double precioFinal;    
    int numeroAsiento;
        
    public DatosVenta(String idVenta, Clientes nombreCliente, double precioBase, double descuentoAplicado, double precioFinal, int numeroAsiento){
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.precioBase = precioBase;
        this.descuentoAplicado = descuentoAplicado;
        this.precioFinal = precioFinal; 
        this.numeroAsiento = numeroAsiento;
    }
    
    public String getUbicacion(Asientos[] asientosArreglo){
        return asientosArreglo[numeroAsiento - 1].getUbicacion();
    }
        
    public static double TraePrecioBase(String ubicacion){
        switch(ubicacion.toLowerCase()){
            case "vip":
                return 35000;
            case "platea":
                return 24000;
            case "balcon":
                return 12000;
            default:
                return 0;
        }
    }
    
    public static void CalculaIngresosTotales(DatosVenta[] ventasArreglos, int indiceVentas){
        if (indiceVentas == 0) {
            System.out.println("No existen ventas registradas");
            return;
        }
        
        double ventasTotales = 0;
        for (int i = 0; i < indiceVentas; i++) {
            ventasTotales += ventasArreglos[i].precioFinal;
        }
        
        System.out.printf("Los Ingresos totales son: $%.2f\n", ventasTotales);
    }

   
}
