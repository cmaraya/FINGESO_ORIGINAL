package com.creative.Fingeso.document;

import java.util.Random;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Local")
public class Local {
    @id
    @NotNull
    //Atributos
    public String dirección;
    public String nombre;
    public String adminstrador;
    public int codigo;
    public int IDLocal;
    public int tiempoEstimadoPorPersona;
    public int TerminoHorarioAtención;
    public int InicioHorarioAtención;
    public int maximoPersonas;
    public int tiempoEsperaMaximo;// se saca con el hprario de atención
    public Cola cola;


    /**
     * Constructor de Local
     */
    public Local(int tiempoEstimadoPorPersona,int InicioHorarioAtención, int TerminoHorarioAtención,String dirección, String nombre, String adminstrador) {

        Random cM = new Random();
        int calculoMaximo = cM.nextInt(10);
        this.maximoPersonas= calculoMaximo;

        Random tE = new Random();
        int calculoTiempo = tE.nextInt(1000);
        this.tiempoEsperaMaximo= calculoTiempo;

        Random c = new Random();
        int calculoCodigo = c.nextInt(100000);
        this.codigo= calculoCodigo;

        Random r = new Random();
        int calculoID = r.nextInt(100);
        this.IDLocal= calculoID;

        Cola col =new Cola(calculoMaximo,tiempoEstimadoPorPersona);
        this.cola=col;

    }


    /**
     * SETTERS
     */
    public void setDireccion(String dire){ this.dirección = dire; }
    public void setNombre(String nom){ this.nombre = nom; }
    public void setAdminstrador(String ad){ this.adminstrador = ad; }
    public void setCodigo(int cod) { this.codigo = cod; }
    public void setIDLocal(int IDLoc) { this.IDLocal = IDLoc; }
    public void setTiempoEstimadoPorPersona(int tiempoEstPersona) { this.tiempoEstimadoPorPersona = tiempoEstPersona; }
    public void setTerminoHorarioAtención(int terminoHorario) { this.TerminoHorarioAtención = terminoHorario; }
    public void setInicioHorarioAtención(int inicioHorario) { this.InicioHorarioAtención = inicioHorario; }
    public void setMaximoPersonas(int maxPersonas) { this.maximoPersonas = maxPersonas; }
    public void setTiempoEsperaMaximo(int tiempoMaximo) { this.tiempoEsperaMaximo = tiempoMaximo; }
    public void setCola(Cola col) { this.cola = col; }

    /**
     * GETTERS
     */
    public String getDireccion() { return dirección; }
    public String getNombre() { return nombre; }
    public String getAdminstrador() { return adminstrador; }
    public int getCodigo() { return codigo; }
    public int getIDLocal() { return IDLocal; }
    public int getTiempoEstimadoPorPersona() { return tiempoEstimadoPorPersona; }
    public int getTerminoHorarioAtención() { return TerminoHorarioAtención; }
    public int getInicioHorarioAtención() { return InicioHorarioAtención; }
    public int getMaximoPersonas() { return maximoPersonas; }
    public int getTiempoEsperaMaximo() { return tiempoEsperaMaximo; }
    public Cola getCola() { return cola; }


    @Override
    public String toString() {
        return "Local{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    /**
     * METODOS
     */
    public Usuario solicitarIngresoCola(String nombre,int telefono)
    {
        Usuario user= new Usuario();
        int X=getIDLocal()*1000;
        int Y=cola.getContador();
        int ticket=X+Y;
        user.setNombreUsuario(nombre);
        user.setTelefono(int telefono);
        user.setTicket(int ticket);
        return user;
    }

    public Usuario cancelarTicket(int ticket){
        Usuario user;
        for(int x=0;x<cola.usuariosCola.size();x++){
            if (cola.usuariosCola.get(x).ticket==ticket){
                user= cola.usuariosCola.get(x);
            }
        }
        return user;
    }

    public int solicitudtiempoInicial(){
        int tiempo=cola.calculaTiempoNuevoUsuario();
        return tiempo;
    }
}
