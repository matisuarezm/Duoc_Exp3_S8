package exp3_s8_matias_suarez;

/**
 * @author msuarez
 */
public class Clientes {
    String idCliente;
    String nombreCliente;
    
    public Clientes(String idCliente, String nombreCLiente){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCLiente;        
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    
}
