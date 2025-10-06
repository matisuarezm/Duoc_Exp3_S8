package exp3_s8_matias_suarez;

/**
 *
 * @author msuarez
 */
public class DatosVenta {
    private String idVenta;
    private Clientes nombreCliente;
    private double precioBase;
    private double descuentoAplicado;
    private double precioFinal;    
    private int numeroAsiento;
        
    public DatosVenta(String idVenta, Clientes nombreCliente, double precioBase, double descuentoAplicado, double precioFinal, int numeroAsiento){
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.precioBase = precioBase;
        this.descuentoAplicado = descuentoAplicado;
        this.precioFinal = precioFinal; 
        this.numeroAsiento = numeroAsiento;
    }
    
    //Obtiene el sector de los asientos
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

    // Getters
    public String getIdVenta() { return idVenta; }
    public Clientes getNombreCliente() { return nombreCliente; }
    public double getPrecioBase() { return precioBase; }
    public double getDescuentoAplicado() { return descuentoAplicado; }
    public double getPrecioFinal() { return precioFinal; }
    public int getNumeroAsiento() { return numeroAsiento; }
    
    //Setters

    public void setIdVenta(String idVenta) { this.idVenta = idVenta; }
    public void setNombreCliente(Clientes nombreCliente) { this.nombreCliente = nombreCliente; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public void setDescuentoAplicado(double descuentoAplicado) { this.descuentoAplicado = descuentoAplicado; }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }
    public void setNumeroAsiento(int numeroAsiento) { this.numeroAsiento = numeroAsiento; }
    

   
}
