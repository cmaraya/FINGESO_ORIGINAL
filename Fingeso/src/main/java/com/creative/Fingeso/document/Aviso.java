package sample;
import java.time.format.*;
import java.util.ArrayList;

public class Aviso {


    public int telefono;
    public  int tiempoRestante;/**tiempo considerados en minutos, que luego sera transformado a su formato de salida**/
    public String comunicado;

    /**
     * Constructor de Aviso
     */
    public Aviso(int fono,int  tiempoR){
        this.telefono=fono ;
        this.tiempoRestante=tiempoR;
        this.comunicado="";
        /**this.personasRestantes=0;**/
    }

    /**
     *SETTERS
     */
    public void setTelefono(int fono) { this.telefono = fono; }
    public void setTiempoRestante(int hora) { this.tiempoRestante = hora; }
    public void setComunicado(String com) { this.comunicado= com; }
   /** public void setPersonasRestantes(int personas) { this.personasRestantes = personas; }**/

    /**
     *GETTERS
     */
    public int getTelefono() { return telefono; }
    public int getTiempoRestante() { return tiempoRestante; }
    public String getComunicado() { return comunicado; }
    /**public int getPersonasRestantes() { return personasRestantes; }**/

}
