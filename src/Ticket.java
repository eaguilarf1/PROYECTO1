/**
 * @author Edward Aguilar
 */
public class Ticket {
    /**
     * Variable que almacena el numero de ticket
     */
    private String correlativo;
    /**
     * Variable que almacena el valor del usuario
     */
    private String nitUsuario;
    /**
     * Variable que almacena el nombre del usuario
     */
    private String nombreUsuario;
    /**
     * Variable que almacena el problema por el
     * cual se crea el ticket
     */
    private String problema;
    /**
     * Variable que almacena la cola en la
     * que se encuentra el ticket
     */
    private String estado;
    /**
     * Variable que almacena la fecha de creacion del ticket
     */
    private String fecha;
    /**
     * Variable que almacena la fecha de creacion del ticket
     */
    private String hora;

    /**
     * @param correlativo   - Numero de ticket
     * @param nitUsuario    - Nit del usuario
     * @param nombreUsuario - Nombre del usuario
     * @param problema      - Motivo de creacion del ticket
     * @param fecha         - Fecha del ticket
     * @param hora          - Hora del ticket
     * @param estado        - Cola en la que se encuentra
     */
    public Ticket(String correlativo, String nitUsuario, String nombreUsuario, String problema, String fecha, String hora, String estado) {
        this.correlativo = correlativo;
        this.nitUsuario = nitUsuario;
        this.nombreUsuario = nombreUsuario;
        this.problema = problema;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }

    //Setter y getters

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getNitUsuario() {
        return nitUsuario;
    }

    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return Muestra la información en pantalla
     */
    @Override
    public String toString() {
        return "Ticket: " +
                "NIT: " + nitUsuario +
                " | Nombre: " + nombreUsuario +
                " | Problema: " + problema +
                " | Estado: " + estado +
                " | Fecha: " + fecha +
                " | Hora: " + hora +
                " | Correlativo: " + correlativo;
    }
}
