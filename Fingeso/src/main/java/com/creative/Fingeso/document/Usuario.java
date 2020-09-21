package sample;

public class Usuario {

    public int telefono;
    public String nombre;
    public int ticket;

    /**
     * Constructor de Usuario
     */
    public Usuario(int telefono,String nombre, int ticket){

        this.telefono=telefono;
        this.nombre=nombre;
        this.ticket=0;
    }

    /**
     *SETTERS
     */
    public void setNombreUsuario(String nombre) { this.nombre = nombre; }
    public void setTelefono(int fono) { this.telefono = fono; }
    public void setTicket(int tick) { this.ticket = tick; }

    /**
     *GETTERS
     */
    public String getNombreUsuario() { return nombre; }
    public int getTelefono() { return telefono; }
    public int getTicket() { return ticket; }

    /**
     *METODOS
     */



}
