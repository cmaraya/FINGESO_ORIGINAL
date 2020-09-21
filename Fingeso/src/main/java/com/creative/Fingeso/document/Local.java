package com.creative.Fingeso.document;

import java.util.Random;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.io.Serializable;




@Document(collection = "Local")
public class Local {
    //Atributos
    public int id;
    public String direccion;
    public String nombre;
    public String administrador;
    public String url;
    public int codigo;
    public int tiempoEstimadoPorPersona;
    public int TerminoHorarioAtencion;
    public int InicioHorarioAtencion;
    public int maximoPersonas;
    public int tiempoEsperaMaximo;// se saca con el hprario de atención
    public Cola cola;


    /**
     * Constructor de Local
     */
    public Local(int id, String direccion , String nombre , String administrador , String url , int codigo , int tiempoEstimadoPorPersona , int TerminoHorarioAtencion , int InicioHorarioAtencion , int maximoPersonas , int tiempoEsperaMaximo , Cola cola) {

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
        this.id= calculoID;

        Cola col =new Cola(calculoMaximo,tiempoEstimadoPorPersona);
        this.cola=col;

    }


    /**
     * SETTERS
     */
    public void setId(int idLoc) {this.id = idLoc;}
    public void setDireccion(String dire){ this.direccion = dire; }
    public void setNombre(String nom){ this.nombre = nom; }
    public void setAdministrador(String ad){ this.administrador = ad; }
    public void setCodigo(int cod) { this.codigo = cod; }
    public void setTiempoEstimadoPorPersona(int tiempoEstPersona) { this.tiempoEstimadoPorPersona = tiempoEstPersona; }
    public void setTerminoHorarioAtencion(int terminoHorario) { this.TerminoHorarioAtencion = terminoHorario; }
    public void setInicioHorarioAtencion(int inicioHorario) { this.InicioHorarioAtencion = inicioHorario; }
    public void setMaximoPersonas(int maxPersonas) { this.maximoPersonas = maxPersonas; }
    public void setTiempoEsperaMaximo(int tiempoMaximo) { this.tiempoEsperaMaximo = tiempoMaximo; }
    public void setCola(Cola col) { this.cola = col; }

    /**
     * GETTERS
     */
    public  int getId() {return id; }
    public String getDireccion() { return direccion; }
    public String getNombre() { return nombre; }
    public String getAdministrador() { return administrador; }
    public String getUrl() { return url; }

    public int getCodigo() { return codigo; }
    public int getTiempoEstimadoPorPersona() { return tiempoEstimadoPorPersona; }
    public int getTerminoHorarioAtencion() { return TerminoHorarioAtencion; }
    public int getInicioHorarioAtencion() { return InicioHorarioAtencion; }
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

        int X=getId()*1000;
        int Y=cola.getContador();
        int ticket=X+Y;
        Usuario user = new Usuario(1,telefono,nombre,ticket);
        return user;
    }

    public Usuario cancelarTicket(int ticket , Usuario usuario){
        Usuario user = new Usuario(usuario.getId(),usuario.getTelefono(),usuario.getNombreUsuario(),usuario.getTicket());
        for(int x=0;x<cola.usuariosCola.size();x++){
            if (cola.usuariosCola.get(x).ticket==ticket){
                user = cola.usuariosCola.get(x);
            }
        }
        return user;
    }

    public int solicitudtiempoInicial(){
        int tiempo=cola.calculaTiempoNuevoUsuario();
        return tiempo;
    }


}
