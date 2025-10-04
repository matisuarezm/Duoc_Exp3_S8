package exp3_s8_matias_suarez;

/**
 * @author msuarez
 */
public class Asientos {
    int numeroAsiento;
    boolean estadoAsiento;
    private String ubicacion;
    
    public Asientos(int numeroAsiento, boolean estadoAsiento){
        this.numeroAsiento = numeroAsiento;
        this.estadoAsiento = estadoAsiento;
        this.ubicacion = asignarUbicacion(numeroAsiento);
    }
    
     public static String[] ubicacionesDisponibles(){
        return new String[]{"vip","platea","balcon"};
    }
     
    //Asignar asientos segun el tipo de asientos
    private String asignarUbicacion(int numeroAsiento){
        if (numeroAsiento >= 1 && numeroAsiento <= 20) {
            return "vip"; 
        }else if (numeroAsiento >=21 && numeroAsiento <=40 ) {
            return "platea";
        }else if(numeroAsiento >=41 && numeroAsiento <=60){
            return "balcon";
        }else {
            return "Desconocido";
        }
    }
    
    public static boolean ubicacionValida(String ubicacion){
        for (String laUbicacion : ubicacionesDisponibles()) {
            if (laUbicacion.equalsIgnoreCase(ubicacion)) {
                return true;
            }
        }
        return false;
    }
    
    public static void inicializarAsientos(Asientos[] asientosArreglo){
        for (int i = 0; i < asientosArreglo.length; i++) {
                asientosArreglo[i] = new Asientos(i + 1, true);
            }
    }
    
    //Getter 6 Setter - toString
    public boolean isEstadoAsiento() {
        return estadoAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }
        
    public void setDisponible(boolean estadoAsiento){
        this.estadoAsiento = estadoAsiento;
    }

    @Override
    public String toString() {
        return "Asientos{" + "numeroAsiento=" + numeroAsiento + ", estadoAsiento=" + estadoAsiento + ", ubicacion=" + ubicacion + '}';
    }
    
}
