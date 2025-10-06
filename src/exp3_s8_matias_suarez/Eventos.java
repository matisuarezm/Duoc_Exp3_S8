package exp3_s8_matias_suarez;

/**
 *
 * @author msuarez
 */
public class Eventos {
    
    private String idEvento;
    private String nombreEvento;
    private String fechaEvento;
    private String horaEvento;
    
    private VendeEntradas gestorVentas;
    
    public Eventos(String idEvento, String nombreEvento, String fechaEvento, String horaEvento, int totalEntradas){
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        
        DatosVenta[] ventasArreglo = new DatosVenta[totalEntradas];
        Asientos[] asientosArreglo = new Asientos[totalEntradas];
        Clientes[] clientesArreglo = new Clientes[totalEntradas];
        
        Asientos.inicializarAsientos(asientosArreglo);
        
        this.gestorVentas = new VendeEntradas(ventasArreglo, asientosArreglo, clientesArreglo, totalEntradas);
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;    
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public VendeEntradas getGestorVentas() {
        return gestorVentas;
    }

    @Override
    public String toString() {
        return nombreEvento + " - Fecha: " + fechaEvento + " - Hora: " + horaEvento ;
    }
    
    
    
    
}
