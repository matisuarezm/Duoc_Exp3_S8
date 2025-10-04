package exp3_s8_matias_suarez;

import java.util.ArrayList;

/**
 * @author msuarez
 */
public class Descuentos {
    private String tipo;
    private double porcentaje;
    
    private static ArrayList<Descuentos> listaDescuentos = new ArrayList<>();
    
    public Descuentos(String tipo, double porcentaje){
        this.tipo = tipo.toLowerCase();
        this.porcentaje = porcentaje;
        
    }
    
    public static void inicializarDescuentos(){
        listaDescuentos.add(new Descuentos("estudiante", 0.10));
        listaDescuentos.add(new Descuentos("terceraedad", 0.15));
        listaDescuentos.add(new Descuentos("general", 0.0));
    }
    
    public static boolean TipoDescuentoValido(String tipoCliente){
        for (Descuentos descuentos : listaDescuentos) {
            if (descuentos.tipo.equalsIgnoreCase(tipoCliente)) {
                return true;
            }
        }
        return false;
    }
        
    public static double obtenerDescuentos(String tipoCliente){
        for (Descuentos losDescuentos : listaDescuentos) {
            if (losDescuentos.tipo.equalsIgnoreCase(tipoCliente)) {
                return losDescuentos.porcentaje;
            }
        }
        return 0.0;
    }
}
